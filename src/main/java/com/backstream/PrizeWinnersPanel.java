package com.backstream;

import com.backstream.response.JsonResponse;
import com.google.gson.Gson;
import com.pingunaut.wicket.chartjs.chart.impl.Pie;
import com.pingunaut.wicket.chartjs.core.panel.LineChartPanel;
import com.pingunaut.wicket.chartjs.core.panel.PieChartPanel;
import com.pingunaut.wicket.chartjs.data.PieChartData;
import com.pingunaut.wicket.chartjs.options.PieChartOptions;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeWinnersPanel extends Panel {
    public PrizeWinnersPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        String result = RestClient.get();
        Gson gson = new Gson();

        JsonResponse response = gson.fromJson(result, JsonResponse.class);
        for (JsonResponse.LaureatesBean laureates : response.getLaureates()) {
            System.out.println(String.format("%s %s %s", laureates.getId(), laureates.getFirstname(), laureates.getSurname()));
        }

        List<JsonResponse.LaureatesBean> laureates = response.getLaureates();
        List<JsonResponse.LaureatesBean> male = laureates.stream().filter(l -> l.getGender().equals("male")).collect(Collectors.toList());
        List<JsonResponse.LaureatesBean> female = laureates.stream().filter(l -> l.getGender().equals("female")).collect(Collectors.toList());

        PieChartData pieChartData1 = new PieChartData(male.size(), "#fbb", "male");
        PieChartData pieChartData2 = new PieChartData(female.size(), "#00f", "female");
        PieChartData pieChartData3 = new PieChartData(laureates.size()-female.size()-male.size(), "#0f0", "others");

        List<PieChartData> data = new ArrayList<>();
        data.add(pieChartData1);
        
        data.add(pieChartData2);
        data.add(pieChartData3);

        Pie pie = new Pie();
        pie.setData(data);

        PieChartPanel pieChartPanel = new PieChartPanel("pieChartPanel", Model.of(pie));
        add(pieChartPanel);

        final ListModel<JsonResponse.LaureatesBean> laureatesModel = new ListModel<>(response.getLaureates());

        ListView<JsonResponse.LaureatesBean> allWinners = new PropertyListView<JsonResponse.LaureatesBean>("allWinners", laureatesModel) {
            @Override
            protected void populateItem(final ListItem<JsonResponse.LaureatesBean> listItem) {
                final Label surname = new Label("surname");
                listItem.add(surname);
                listItem.add(new WebMarkupContainer("nameSeparator") {
                    @Override
                    public boolean isVisible() {
                        return surname.getDefaultModelObject() != null;
                    }
                });
                listItem.add(new Label("firstname"));
                listItem.add(new Label("gender"));
                listItem.add(new Label("born"));
                listItem.add(new Label("bornCountry"));
                listItem.add(new Label("bornCity"));
                listItem.add(new Label("died"));
                listItem.add(new Label("diedCountry"));
                listItem.add(new Label("diedCity"));
                listItem.add(new PrizesPanel("prizes", PropertyModel.<List<JsonResponse.LaureatesBean.PrizesBean>>of(listItem.getModel(), "prizes")));
            }
        };
        add(allWinners);
    }
}
