
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { Utility } from '../../providers/utility';
import { App } from 'ionic-angular';

import { NewsApiService } from '../../services/newsapi.service';


@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
 
  order : any;
  category : any;
  mag : any;
  source : any;
  news = [];
    
  constructor(public app: App, public navCtrl: NavController, public utility: Utility, public newsApiService: NewsApiService, public navParams: NavParams) {
    // J'ai déplacé la récupération des articles dans une méthode appropriée
    this.source = navParams.data;
    this.category = "monde";
    this.mag = "telquel";
    //this.getArticles(null);
  }

  ionViewDidLoad() {
        this.app.setTitle('News');    
        this.updateHangout();
  }

  updateHangout() {
      //Show loading
        var loading = this.utility.getLoader();
        loading.present();

        this.newsApiService.getArticles(this.source).subscribe(data => {
        
            this.news = data;

           //Hide loading
            setTimeout(function(){
                loading.dismiss();
            },1000); 

        });
  
  }



}
