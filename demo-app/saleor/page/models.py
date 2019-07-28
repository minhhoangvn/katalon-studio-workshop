from django.conf import settings
from django.db import models
from django.urls import reverse
from django.utils.html import strip_tags
from django.utils.translation import pgettext_lazy
from draftjs_sanitizer import clean_draft_js

from ..core.fields import SanitizedJSONField
from ..core.models import PublishableModel, PublishedQuerySet
from ..core.utils import build_absolute_uri
from ..core.utils.draftjs import json_content_to_raw_text
from ..core.utils.translations import TranslationProxy
from ..seo.models import SeoModel, SeoModelTranslation


class PagePublishedQuerySet(PublishedQuerySet):
    @staticmethod
    def user_has_access_to_all(user):
        return user.is_active and user.has_perm("page.manage_pages")


class Page(SeoModel, PublishableModel):
    slug = models.SlugField(unique=True, max_length=100)
    title = models.CharField(max_length=200)
    content = models.TextField(blank=True)
    content_json = SanitizedJSONField(
        blank=True, default=dict, sanitizer=clean_draft_js
    )
    created = models.DateTimeField(auto_now_add=True)

    objects = PagePublishedQuerySet.as_manager()
    translated = TranslationProxy()

    class Meta:
        ordering = ("slug",)
        permissions = (
            ("manage_pages", pgettext_lazy("Permission description", "Manage pages.")),
        )

    def __str__(self):
        return self.title

    @property
    def plain_text_content(self):
        if settings.USE_JSON_CONTENT:
            return json_content_to_raw_text(self.content_json)
        return strip_tags(self.content)

    def get_absolute_url(self):
        return reverse("page:details", kwargs={"slug": self.slug})

    def get_full_url(self):
        return build_absolute_uri(self.get_absolute_url())


class PageTranslation(SeoModelTranslation):
    language_code = models.CharField(max_length=10)
    page = models.ForeignKey(
        Page, related_name="translations", on_delete=models.CASCADE
    )
    title = models.CharField(max_length=255, blank=True)
    content = models.TextField(blank=True)
    content_json = SanitizedJSONField(
        blank=True, default=dict, sanitizer=clean_draft_js
    )

    class Meta:
        unique_together = (("language_code", "page"),)

    def __repr__(self):
        class_ = type(self)
        return "%s(pk=%r, title=%r, page_pk=%r)" % (
            class_.__name__,
            self.pk,
            self.title,
            self.page_id,
        )

    def __str__(self):
        return self.title
