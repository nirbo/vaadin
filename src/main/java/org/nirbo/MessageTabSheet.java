package org.nirbo;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.nirbo.Model.Message;

public class MessageTabSheet extends TabSheet {

    Table messageTable;
    Label addMessageLabel;

    public MessageTabSheet() {
        setSizeFull();
        VerticalLayout showMessagesTab = new VerticalLayout();
        VerticalLayout addMessageTab = new VerticalLayout();

        messageTable = createShowMessageTable();
        addMessageLabel = createAddMessage();

        addTab(showMessagesTab).setCaption("Show Messages");
        showMessagesTab.addComponent(messageTable);
        addTab(addMessageTab).setCaption("Add a Message");
        addMessageTab.addComponent(addMessageLabel);
    }

    private Table createShowMessageTable() {
        JPAContainer<Message> messages = JPAContainerFactory.make(Message.class, "cinemallPU");
        Object[] messageTableColumns = {"id", "title", "content", "published_date", "start_date", "end_date", "active"};
        String[] messageTableHeaders = {"ID", "Title", "Content", "Published Date", "Start Date", "End Date", "Active"};

        Table showMessageTable = new Table("", messages);
        showMessageTable.setVisibleColumns(messageTableColumns);
        showMessageTable.setColumnHeaders(messageTableHeaders);
        showMessageTable.setSizeFull();
        showMessageTable.setSelectable(true);
        showMessageTable.setBuffered(true);
        showMessageTable.setEditable(true);
        showMessageTable.setImmediate(true);

        System.out.println(messages.getContainerPropertyIds());

//        showMessageTable.addContainerProperty("Title", String.class, null);
//        showMessageTable.addContainerProperty("Content", String.class, null);
//        showMessageTable.addContainerProperty("Published Date", String.class, null);
//        showMessageTable.addContainerProperty("Start Date", String.class, null);
//        showMessageTable.addContainerProperty("End Date", String.class, null);
//        showMessageTable.addContainerProperty("Active", String.class, null);

        return showMessageTable;
    }

    private Label createAddMessage() {
        Label tempLabel = new Label("Temporary Placeholder");
        return tempLabel;
    }

}
