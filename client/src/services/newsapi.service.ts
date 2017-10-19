import { Observable } from 'rxjs/Observable';
import { Injectable }   from '@angular/core';
import { Http, Response }         from '@angular/http';

import 'rxjs/add/operator/map';


@Injectable()
export class NewsApiService {

    private baseUrl: string = 'http://localhost:8080/';


    constructor(private http: Http) {

	}

    public getArticles(mag): Observable<any> {
		//const url = `${this.baseUrl}/${sourceName}/${order}`;
        const url = `${this.baseUrl}${mag}`;

         return this.http.get(url).map((response: Response) => response.json());
    }

}