
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { Utility } from '../../providers/utility';
import { App } from 'ionic-angular';

import { NewsApiService } from '../../services/newsapi.service';


@Component({
  selector: 'page-articleLinked',
  templateUrl: 'articleLinked.html'
})

export class ArticleLinked {
 
  
  link : any;
  item : any;
  source : any;
  subTitle : any;
  body : any;

  constructor(public app: App, public navCtrl: NavController, public utility: Utility, public newsApiService: NewsApiService, public navParams: NavParams) {
    // J'ai déplacé la récupération des articles dans une méthode appropriée
    this.item = navParams.data;
    this.link = this.item.url;

  }

  ionViewDidLoad() {
        this.app.setTitle('News');    
        this.updateHangout();
  }

  updateHangout() {
      //Show loading
        var loading = this.utility.getLoader();
        loading.present();

        this.newsApiService.getArticleLinked("telquel",this.link).subscribe(data => {
        
            this.subTitle = data.subTitle;
            this.body = data.body;
           //Hide loading
            setTimeout(function(){
                loading.dismiss();
            },1000); 

        });
  
  }



}
