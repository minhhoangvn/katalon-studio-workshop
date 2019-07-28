import DialogContentText from "@material-ui/core/DialogContentText";
import IconButton from "@material-ui/core/IconButton";
import DeleteIcon from "@material-ui/icons/Delete";
import React from "react";

import ActionDialog from "@saleor/components/ActionDialog";
import useBulkActions from "@saleor/hooks/useBulkActions";
import useListSettings from "@saleor/hooks/useListSettings";
import useNavigator from "@saleor/hooks/useNavigator";
import usePaginator, {
  createPaginationState
} from "@saleor/hooks/usePaginator";
import i18n from "@saleor/i18n";
import { getMutationState, maybe } from "@saleor/misc";
import { ListViews } from "@saleor/types";
import { CategoryListPage } from "../components/CategoryListPage/CategoryListPage";
import { TypedCategoryBulkDeleteMutation } from "../mutations";
import { TypedRootCategoriesQuery } from "../queries";
import { CategoryBulkDelete } from "../types/CategoryBulkDelete";
import {
  categoryAddUrl,
  categoryListUrl,
  CategoryListUrlQueryParams,
  categoryUrl
} from "../urls";

interface CategoryListProps {
  params: CategoryListUrlQueryParams;
}

export const CategoryList: React.StatelessComponent<CategoryListProps> = ({
  params
}) => {
  const navigate = useNavigator();
  const paginate = usePaginator();
  const { isSelected, listElements, toggle, toggleAll, reset } = useBulkActions(
    params.ids
  );
  const { updateListSettings, settings } = useListSettings(
    ListViews.CATEGORY_LIST
  );
  const paginationState = createPaginationState(settings.rowNumber, params);
  return (
    <TypedRootCategoriesQuery displayLoader variables={paginationState}>
      {({ data, loading, refetch }) => {
        const { loadNextPage, loadPreviousPage, pageInfo } = paginate(
          maybe(() => data.categories.pageInfo),
          paginationState,
          params
        );

        const handleCategoryBulkDelete = (data: CategoryBulkDelete) => {
          if (data.categoryBulkDelete.errors.length === 0) {
            navigate(categoryListUrl(), true);
            refetch();
            reset();
          }
        };
        return (
          <TypedCategoryBulkDeleteMutation
            onCompleted={handleCategoryBulkDelete}
          >
            {(categoryBulkDelete, categoryBulkDeleteOpts) => {
              const bulkDeleteState = getMutationState(
                categoryBulkDeleteOpts.called,
                categoryBulkDeleteOpts.loading,
                maybe(
                  () => categoryBulkDeleteOpts.data.categoryBulkDelete.errors
                )
              );

              return (
                <>
                  <CategoryListPage
                    categories={maybe(
                      () => data.categories.edges.map(edge => edge.node),
                      []
                    )}
                    settings={settings}
                    onAdd={() => navigate(categoryAddUrl())}
                    onRowClick={id => () => navigate(categoryUrl(id))}
                    disabled={loading}
                    onNextPage={loadNextPage}
                    onPreviousPage={loadPreviousPage}
                    onUpdateListSettings={updateListSettings}
                    pageInfo={pageInfo}
                    isChecked={isSelected}
                    selected={listElements.length}
                    toggle={toggle}
                    toggleAll={toggleAll}
                    toolbar={
                      <IconButton
                        color="primary"
                        onClick={() =>
                          navigate(
                            categoryListUrl({
                              ...params,
                              action: "delete",
                              ids: listElements
                            })
                          )
                        }
                      >
                        <DeleteIcon />
                      </IconButton>
                    }
                  />
                  <ActionDialog
                    confirmButtonState={bulkDeleteState}
                    onClose={() =>
                      navigate(
                        categoryListUrl({
                          ...params,
                          action: undefined,
                          ids: undefined
                        })
                      )
                    }
                    onConfirm={() =>
                      categoryBulkDelete({
                        variables: {
                          ids: params.ids
                        }
                      })
                    }
                    open={params.action === "delete"}
                    title={i18n.t("Remove categories")}
                    variant="delete"
                  >
                    <DialogContentText
                      dangerouslySetInnerHTML={{
                        __html: i18n.t(
                          "Are you sure you want to remove <strong>{{ number }}</strong> categories?",
                          {
                            number: maybe(
                              () => params.ids.length.toString(),
                              "..."
                            )
                          }
                        )
                      }}
                    />
                    <DialogContentText>
                      {i18n.t(
                        "Remember that this will also remove all products assigned to this category."
                      )}
                    </DialogContentText>
                  </ActionDialog>
                </>
              );
            }}
          </TypedCategoryBulkDeleteMutation>
        );
      }}
    </TypedRootCategoriesQuery>
  );
};
export default CategoryList;
