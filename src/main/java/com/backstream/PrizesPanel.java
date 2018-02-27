package com.backstream;

import com.backstream.response.JsonResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import java.util.List;

public class PrizesPanel extends GenericPanel<List<JsonResponse.LaureatesBean.PrizesBean>> {
    public PrizesPanel(String id, IModel<List<JsonResponse.LaureatesBean.PrizesBean>> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        ListView<JsonResponse.LaureatesBean.PrizesBean> prizes = new PropertyListView<JsonResponse.LaureatesBean.PrizesBean>("prizes", getModel()) {
            @Override
            protected void populateItem(ListItem<JsonResponse.LaureatesBean.PrizesBean> item) {
                item.add(new Label("year"));
                item.add(new Label("category"));
                item.add(new Label("share"));
                item.add(new Label("motivation"));
            }
        };
        add(prizes);
    }
}
