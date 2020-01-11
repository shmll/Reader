package org.swdc.reader.core.readers;

import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.swdc.reader.core.BookLocator;
import org.swdc.reader.core.BookReader;
import org.swdc.reader.core.RenderResolver;
import org.swdc.reader.core.configs.EpubConfig;
import org.swdc.reader.core.configs.TextConfig;
import org.swdc.reader.core.locators.EpubLocator;
import org.swdc.reader.core.views.EpubRenderView;
import org.swdc.reader.entity.Book;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by lenovo on 2019/6/13.
 */
@Component
public class EpubReader implements BookReader<String> {

    @Autowired
    private EpubConfig config;

    @Autowired
    private TextConfig textConfig;

    @Autowired
    private EpubRenderView view;

    @Autowired
    private Executor asyncExecutor;

    @Autowired
    private List<RenderResolver> resolvers;

    private EpubLocator locator;

    private Book book;

    @Override
    public void setBook(Book book) {
        if (locator != null) {
            locator.finalizeResources();
            locator = null;
        }
        this.book = book;
        locator = new EpubLocator(resolvers,asyncExecutor,book, config, textConfig);
    }

    @Override
    public Book getBook() {
        return book;
    }

    @Override
    public void renderPage(String pageData, BorderPane view) {
        WebView webView = (WebView) view.lookup("#" + this.view.getViewId());
        if (webView == null) {
            view.setCenter(this.view.getView());
            webView = (WebView) this.view.getView();
        }
        webView.getEngine().loadContent(pageData);
    }

    @Override
    public boolean isSupport(Book target) {
        return target.getName().endsWith("epub") &&
                target.getMimeData().equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    }

    @Override
    public BookLocator<String> getLocator() {
        return locator;
    }
}
