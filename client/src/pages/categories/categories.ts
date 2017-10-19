import { HomePage } from './../home/home';
import { Component } from '@angular/core';

import {ActionSheet, ActionSheetController, AlertController, App, ModalController, NavController, NavParams } from 'ionic-angular';


import { Utility } from '../../providers/utility';



@Component({
  selector: 'page-categories',
  templateUrl: 'categories.html'
})
export class CategoriesPage {

  categories = ["SOCIETE","MONDE","ECONOMIE","POLITIQUE","SPORT","MEDIAS","INSOLITE"];
  
  actionSheet: ActionSheet;

  source : any;

  api : any;

  constructor(
    public alertCtrl: AlertController,
    public app: App,
    public modalCtrl: ModalController,
    public navCtrl: NavController,
    public utility: Utility,
    public actionSheetCtrl: ActionSheetController,
    public navParams: NavParams
  ) {
    this.source = navParams.data;
  }

  ionViewDidLoad() {
    this.app.setTitle('Categories');    
    this.updateHangout();
  }

  updateHangout() {
    //Show loading
    var loading = this.utility.getLoader();
    loading.present();

      //Hide loading
      setTimeout(function(){
        loading.dismiss();
      },1000);

    
  }


  goToHome(item) {
    let nav = this.app.getRootNav();
    
    this.api = this.source+"/"+item;
    nav.push(HomePage,this.api);
  } 

}
