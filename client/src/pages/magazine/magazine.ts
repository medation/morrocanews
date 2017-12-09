import { Categorie } from './../categorie/categorie';
import { Articles } from './../articles/articles';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ActionSheetController } from 'ionic-angular';
import { Utility } from '../../providers/utility';


import { ProviderData } from '../../providers/prov-data';

import { App } from 'ionic-angular';



@Component({
  selector: 'page-magazine',
  templateUrl: 'magazine.html',
})

export class Magazine {

    sources = [];
    categories = [];
    api : any;
    src : String;

    constructor(public app: App, 
                public sourcesData: ProviderData, 
                public utility: Utility,
                public navParams: NavParams,
                public actionSheetCtrl: ActionSheetController) {
 
        
    }

    ionViewDidLoad() {
        this.app.setTitle('Source');    
        this.updateHangout();
    }

    updateHangout() {
        //Show loading
        var loading = this.utility.getLoader();
        loading.present();

        this.sourcesData.getSources().subscribe(data => {
        
            this.sources = data;

           //Hide loading
            setTimeout(function(){
                loading.dismiss();
            },1000); 

        });
    
    }


    goToCategorie(item) {

        let nav = this.app.getRootNav();
        nav.push(Categorie,item);

    }


}
