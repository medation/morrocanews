import { Articles } from './../articles/articles';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Utility } from '../../providers/utility';


import { ProviderData } from '../../providers/prov-data';

import { App } from 'ionic-angular';


@Component({
  selector: 'page-categorie',
  templateUrl: 'categorie.html',
})

export class Categorie {

    categories = [];
    mag : any;

    constructor(    public app: App, 
                    public activityData: ProviderData, 
                    public utility: Utility,
                    public navParams: NavParams ) 
    { 
        this.mag = navParams.data;
    }

    ionViewDidLoad() {
        this.app.setTitle('Categorie');    
        this.updateHangout();
    }

    updateHangout() {
        //Show loading
        var loading = this.utility.getLoader();
        loading.present();

            this.categories = this.mag.categories;

           //Hide loading
            setTimeout(function(){
                loading.dismiss();
            },1000); 

    
    }

    goToArticles(categorie) {
        let nav = this.app.getRootNav();
        nav.push(Articles,{mag: this.mag, category: categorie});
    }

}
