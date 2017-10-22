


import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { Storage, IonicStorageModule } from '@ionic/storage';

import { MyApp } from './app.component';
import { Open } from '../pages/open/open';
import { Dashboard } from './../pages/dashboard/dashboard';
import { Articles } from '../pages/articles/articles';
import { ArticleLinked } from './../pages/articleLinked/articleLinked';
import { Magazine } from '../pages/magazine/magazine';

import { ProviderData } from '../providers/prov-data';
import { Utility } from '../providers/utility';

import { NewsApiService } from '../services/newsapi.service';
import { HttpModule } from "@angular/http";

@NgModule({
  declarations: [
    MyApp,
    ArticleLinked,
    Articles,
    Magazine,
    Dashboard,
    Open
  ],
  imports: [
    HttpModule,
    BrowserModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    ArticleLinked,
    Articles,
    Magazine,
    Dashboard,
    Open
  ],
  providers: [
    ProviderData,
    Utility,
    NewsApiService,
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
