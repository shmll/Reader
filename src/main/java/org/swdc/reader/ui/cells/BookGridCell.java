package org.swdc.reader.ui.cells;

import org.controlsfx.control.GridCell;
import org.swdc.reader.entity.Book;
import org.swdc.reader.ui.views.BookCellView;

/**
 * Created by lenovo on 2019/5/22.
 */
public class BookGridCell extends GridCell<Book> {

    private BookCellView view;

    public BookGridCell(BookCellView view) {
        this.view = view;
    }

    @Override
    protected void updateItem(Book item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            return;
        }
        setGraphic(view.getView());
        view.setBook(item);
    }
}
