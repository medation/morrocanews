import { Magazine } from './../magazine/magazine';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Utility } from '../../providers/utility';


import { ProviderData } from '../../providers/prov-data';

import { App } from 'ionic-angular';


@Component({
  selector: 'page-dashboard',
  templateUrl: 'dashboard.html',
})

export class Dashboard {

    activities = [];
 
    constructor(    public app: App, 
                    public activityData: ProviderData, 
                    public utility: Utility,
                    public navParams: NavParams ) 
    { 

    }

    ionViewDidLoad() {
        this.app.setTitle('Accueil');    
        this.updateHangout();
    }

    updateHangout() {
        //Show loading
        var loading = this.utility.getLoader();
        loading.present();

        this.activityData.getActivity().subscribe(data => {
        
            this.activities = data;

           //Hide loading
            setTimeout(function(){
                loading.dismiss();
            },1000); 

        });
    
    }

    goTo(item){
        
        let nav = this.app.getRootNav();

        if(item.name == "news") { nav.push(Magazine) };
        if(item.name == "mangas") { };
    }

}
