package com.base.core.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import com.base.core.utils.consts.Const;

public class HttpCall {

    /**
    *
    * @param path
    * @param params
    * @return
    */
   public static String httpCall( String path, String params )
   {
       String resBody =  "";

       try {

           HttpClient client = HttpClientBuilder.create().build();
           HttpPost postRequest = new HttpPost( Const.BASE_URL + path );
           postRequest.setHeader( "Accept", "application/json" );
           postRequest.setHeader( "Content-Type", "application/json" );
           postRequest.setEntity( new StringEntity( params, "UTF-8" ) );


           HttpEntity cHttpEntity =   postRequest.getEntity();
           InputStreamReader cInputStreamReader = new InputStreamReader( cHttpEntity.getContent() );
           BufferedReader cBufferedReader = new BufferedReader( cInputStreamReader );

           System.out.println(" REQUEST URL ["+postRequest+"]");
           System.out.println(" REQUEST PARAMETER ["+cBufferedReader.readLine()+"]");

           HttpResponse response = client.execute( postRequest );

           System.out.println("  >>>> " + response.getStatusLine().getStatusCode() );

           if ( response.getStatusLine().getStatusCode() == HttpStatus.SC_OK )
           {
               ResponseHandler<String> resHandler = new BasicResponseHandler();
               resBody = resHandler.handleResponse( response );
           }

           System.out.println(" RESPONSE BODY ["+resBody+"]");
       } catch (Exception e) {
           e.printStackTrace();
       }

       return resBody;
   }

}
