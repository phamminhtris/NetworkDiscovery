package me.triminhpham.localnetworkservicediscovery.main;

import me.triminhpham.localnetworkservicediscovery.data.LocalServiceInfo;

/**
 * Created by Tri Pham on 12/17/17.
 */

/**
 * A presenter that handles the user input passed from view
 * It also makes sure that the data got from model is well formatted
 */
public class MainPresenter implements MainMvp.Presenter {

    private MainMvp.View mView;
    private MainMvp.Model mModel;

    /**
     * Construct a presenter
     *
     * @param view  a view that will be controlled by this presenter
     * @param model a model that provide discovery service
     */
    public MainPresenter(MainMvp.View view, MainMvp.Model model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void onServiceFound(LocalServiceInfo serviceInfo) {
        //mView.showService(serviceInfo);
        mView.showServiceList(mModel.getDeviceList());
    }

    @Override
    public void onServiceRemove(LocalServiceInfo serviceInfo) {
        mView.removeService(serviceInfo);
    }

    @Override
    public void setModel(MainMvp.Model model) {
        mModel = model;
    }

    @Override
    public void setView(MainMvp.View view) {
        mView = view;
        view.showServiceList(mModel.getDeviceList());
    }
}
