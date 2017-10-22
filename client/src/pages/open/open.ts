import { Dashboard } from './../dashboard/dashboard';
import { Magazine } from './../magazine/magazine';
import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { App } from 'ionic-angular';

@Component({
  selector: 'page-open',
  templateUrl: 'open.html'
})

export class Open {
 
    
  constructor(public app: App) {
    
  }

  ionViewDidLoad() {
        this.app.setTitle("Loading")
        this.updateHangout();

  }

  updateHangout() {

    let nav = this.app.getRootNav();
    setTimeout(function(){
        nav.push(Magazine);
    },2000);
  
  }



}