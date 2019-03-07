package com.example.geddi;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PlacesName{
    double longitude;
    double latitude;
    String url="";
    URL link=null;
    String res="{\n" +
            "   \"html_attributions\" : [],\n" +
            "   \"next_page_token\" : \"CqQCFQEAAAv0BPW3KMh5mp3DS-DEPj3WaNhLbRscPoFU4dz94FX1u80xG-w8fj9gKn-i7hWX4NSRbM2lkra293r3ngi8ghj6QP0rIzxxEmito9LHm2ZEltYMJpSMwKuwQ_wI5kFHbjFOwPfKocHbIQa_u45TE4j0dCl47XjUewWgNCz8C5R6pIMWmlLFHB3cNp7vIB1JVuEXana_IfWXJO4z072D0g6KzwWHo1rTC7AswVBNFOV2VrjBR6kYiVOjswJtqrAsUTFhYCJdAmIL5V9y4OdQ8kISrgIUvrdNgEEfRapqnP82bAy44maH4IH55W3gDj__u8FJGttxWRrFpfyGkaHBB_8g5mgiiQWSwBUAaCGKVQ6bomC_8_lNILHAGwAdldjTDRIQ7mcw6gudeEi7LbffeKDYLBoUvSAnuuOACGbJeSHG5emFIXy4-40\",\n" +
            "   \"results\" : [\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7333148,\n" +
            "               \"lng\" : 76.7794179\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.800142,\n" +
            "                  \"lng\" : 76.8362439\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.6700209,\n" +
            "                  \"lng\" : 76.690814\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png\",\n" +
            "         \"id\" : \"2ff3ad0666fc5f99d36aa80f35cf1e9d61ade100\",\n" +
            "         \"name\" : \"Chandigarh\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 2448,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114020612698176703769/photos\\\"\\u003eAlan Joseph\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAANTS6N9kAzA8aJHJLwu0wsM0K_yk05eQWJSzqaYeg2acKQ-RxBpIOi1FPlo9xEQevHZrWqR5TIwgxsIg5BKlV8rmMJ2JD01-B2zEowXwsFK75cWkvN1dQh6cgnWUl1DXbEhDUE7jvjwhQbvbBQod167UdGhTDW0DG-NpTg7mhZiWGXMnZQxYb7g\",\n" +
            "               \"width\" : 3264\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJa8lu5gvtDzkR_hlzUvln_6U\",\n" +
            "         \"reference\" : \"ChIJa8lu5gvtDzkR_hlzUvln_6U\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"locality\", \"political\" ],\n" +
            "         \"vicinity\" : \"Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.728519,\n" +
            "               \"lng\" : 76.7672681\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7298122802915,\n" +
            "                  \"lng\" : 76.76852478029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7271143197085,\n" +
            "                  \"lng\" : 76.76582681970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"c8cd0cef09ff6b9ae1d14ddd2e9340676c997301\",\n" +
            "         \"name\" : \"Hotel Diamond Plaza\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 3120,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/102083101905625155246/photos\\\"\\u003eYash Manjrekar\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA3CKhEMgGgCHA1ZOnP4DmeYs3vj_dIYN1NtEgJV-5BFyzg9D6Ot1A81W4xz4OIsMwMCkyBIsR6FcNlSI84kKzxJufKrD1TsWbFUmUoCFbMH5VavOVTk1TYu9-2wY5oCkCEhBvCpnyNCSAbRr8QB2muJw8GhSVxo9dx_A7xBBg2SclyZVMeD2DhQ\",\n" +
            "               \"width\" : 4160\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJf-e8UKTtDzkR1hy7_1akqlM\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQH8+CW Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQH8+CW\"\n" +
            "         },\n" +
            "         \"rating\" : 3.7,\n" +
            "         \"reference\" : \"ChIJf-e8UKTtDzkR1hy7_1akqlM\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 714,\n" +
            "         \"vicinity\" : \"SCO 2927-28, Sec-22C, Opposite Markfed, Sector 22C, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7266978,\n" +
            "               \"lng\" : 76.7668267\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7282693802915,\n" +
            "                  \"lng\" : 76.76848668029152\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7255714197085,\n" +
            "                  \"lng\" : 76.7657887197085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"7afdf01f18783c94c4c206e34c825a3d07b3d7ed\",\n" +
            "         \"name\" : \"JW Marriott Hotel Chandigarh\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 806,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/106698635824396544216/photos\\\"\\u003eManish Thakur\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAyg5lSFFaucsJvhlqcnduZyVguEBhXgjXkH-VaTdPbkTPLP6wmIfp4kPC2gSAXPe3_-qQeXq-a8GKwREeS-JMyBvOpyupIIPsO21hnqsrzaX3DJpIPhRg6_RnRIdVehzCEhBJzJSD9w4Xz1787ZOfJ1_FGhSnDm-NW_ntNmD0h-2HUq-YOFNLuw\",\n" +
            "               \"width\" : 1080\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJwwccS7DtDzkRH5N98wFcJH4\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQG8+MP Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQG8+MP\"\n" +
            "         },\n" +
            "         \"rating\" : 4.5,\n" +
            "         \"reference\" : \"ChIJwwccS7DtDzkRH5N98wFcJH4\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 7148,\n" +
            "         \"vicinity\" : \"Plot no: 6, Dakshin Marg, 35B, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.70813559999999,\n" +
            "               \"lng\" : 76.80282889999999\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.70953138029149,\n" +
            "                  \"lng\" : 76.80424558029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7068334197085,\n" +
            "                  \"lng\" : 76.8015476197085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"de0ee4e0f4f86c534282bc835ff4ba406660477c\",\n" +
            "         \"name\" : \"Hometel Chandigarh\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 643,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109823995306386720029/photos\\\"\\u003eHometel Chandigarh\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAa-gFoEE0zI-TAapwV4-Xs52Oy89rVvIdAiIGWJRIrv6AkSA9toxK7rC8s__kIDzeZAY-7RgWf-yimPUawDDEOi8zzqOT09qvTVnjNS08Oue_t5e9kYnVtKpvKAdMyBEBEhDflvIJuuXdzHTVom5yQBK6GhT4TWqhAS_fCqDm-K9XxqX-QdrwLg\",\n" +
            "               \"width\" : 1000\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJL3hKVersDzkRNA1xGy6RVv4\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PR53+74 Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPR53+74\"\n" +
            "         },\n" +
            "         \"rating\" : 4.1,\n" +
            "         \"reference\" : \"ChIJL3hKVersDzkRNA1xGy6RVv4\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [\n" +
            "            \"bar\",\n" +
            "            \"lodging\",\n" +
            "            \"restaurant\",\n" +
            "            \"point_of_interest\",\n" +
            "            \"food\",\n" +
            "            \"establishment\"\n" +
            "         ],\n" +
            "         \"user_ratings_total\" : 2612,\n" +
            "         \"vicinity\" : \"Plot No. 147, 148, Industrial Area Phase I, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.70544309999999,\n" +
            "               \"lng\" : 76.8030359\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.70671658029149,\n" +
            "                  \"lng\" : 76.8045175802915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.70401861970849,\n" +
            "                  \"lng\" : 76.8018196197085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"5df15a97f74351e321207eccb183775371db64ab\",\n" +
            "         \"name\" : \"Lemon Tree Hotel, Chandigarh\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 800,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/100670942598751516911/photos\\\"\\u003eLemon Tree Hotel, Chandigarh\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAJr0IgLTAvILSLg01-ej8FAmX2CRfPak0aT4m71N8ySSN0rYTBh5micRmroZJ8bLtjq7Pl10SOmwkNzBxLPl-QE-BPyT0agjlkeVMcn_CiGaudK-jnAcW-jEshElYJubCEhBcOxzlbn-SB-8_vcNPTne0GhQVB1KKLRYWJ6PV620oeE3rVNjJIA\",\n" +
            "               \"width\" : 800\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJL6TVyQvtDzkRuih6zLyp6OA\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PR43+56 Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPR43+56\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"ChIJL6TVyQvtDzkRuih6zLyp6OA\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"restaurant\", \"point_of_interest\", \"food\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 1638,\n" +
            "         \"vicinity\" : \"Plot No. 3, MW, Industrial Area Phase I, Industrial Area\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7429847,\n" +
            "               \"lng\" : 76.78655979999999\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.74444143029149,\n" +
            "                  \"lng\" : 76.7878217302915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.74174346970849,\n" +
            "                  \"lng\" : 76.78512376970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"6c782eb8277b9d9b2c52c4ac9ffe632aef1228cc\",\n" +
            "         \"name\" : \"Hotel Oyster\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 3096,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/101795321635853280201/photos\\\"\\u003evishal9835\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAACmNce3uuHU9zsWcdy1SsmvpHEgPdWRDmD6FXkK-dQWjlM6LDFSDbcFxdoJzlSroECQtHOVdoVCfpwoupGX-zXfzSkYOcZ0rg0Ursj_fFGPZPn3h6aUOO_tHeW5hmI6f6EhAWjzi8aj9MIWjlYAtKA7uQGhQAck-SCmNjCOVfQ3YsBxRM7oNSFg\",\n" +
            "               \"width\" : 4128\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJZywkZQztDzkReJHym7KiNiE\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQVP+5J Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQVP+5J\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"ChIJZywkZQztDzkReJHym7KiNiE\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 1259,\n" +
            "         \"vicinity\" : \"SCO 1-2-3 Sector 17A, Opp. Hotel Taj\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.6627123,\n" +
            "               \"lng\" : 76.8376651\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.6639641802915,\n" +
            "                  \"lng\" : 76.8390433302915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.6612662197085,\n" +
            "                  \"lng\" : 76.8363453697085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"df39a98b024afc61ebcfdc94431caa459da02d84\",\n" +
            "         \"name\" : \"Hotel Sun Park, Chandigarh - Zirakpur\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 800,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109267358192217385263/photos\\\"\\u003eHotel Sun Park, Chandigarh - Zirakpur\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAREnM0Bi4SHeIHHRdA5aq6xAouncLusiPMNI9f4Puz5jbeMKsEiIKcl3Lq1CXruSEfWV8pmzwamW882z4f6-vCOvKg75RMTb-xNtFFWdsEHOU54N6Py9IKc4eLiSt6SsiEhDIqOvk0M1wTyRtXt4FlelqGhQ9eh02CE5Eou9H_erdTkVvkECG0Q\",\n" +
            "               \"width\" : 801\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJRZ344rmUDzkRERSZEtobw6k\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"MR7Q+33 Panchkula, Haryana, India\",\n" +
            "            \"global_code\" : \"8J2RMR7Q+33\"\n" +
            "         },\n" +
            "         \"rating\" : 3.8,\n" +
            "         \"reference\" : \"ChIJRZ344rmUDzkRERSZEtobw6k\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 1739,\n" +
            "         \"vicinity\" : \"Chandigarh - Zirakpur - Shimla, NH 22, Zirakpur\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7455624,\n" +
            "               \"lng\" : 76.7852158\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.74685133029149,\n" +
            "                  \"lng\" : 76.7860778302915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7441533697085,\n" +
            "                  \"lng\" : 76.78337986970848\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"b68a7bb2d39df74a3b8046412bc5e9281279ed8b\",\n" +
            "         \"name\" : \"Taj Chandigarh\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 1173,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/105129979299432811167/photos\\\"\\u003eTaj Chandigarh\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAGmLOer-mqSu9dMCMwLeikGTskVWBaM_8onDI6IdVvBc7Ddy7FscAkGkxYiyN2kcrFKGedMYUBXRFROBTYtRBWwBSxFlxuPeeUDeBJ_CL2JFM6hgWT7v59Hlh-h5eAq3uEhBpZnlcXCI5fMVxKxGrEY0RGhSvQ8I7tlwhV90h3pIfpSoidv8oig\",\n" +
            "               \"width\" : 1176\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJiapHigkJGjkRkW4AE-Ew78A\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQWP+63 Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQWP+63\"\n" +
            "         },\n" +
            "         \"rating\" : 4.4,\n" +
            "         \"reference\" : \"ChIJiapHigkJGjkRkW4AE-Ew78A\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 3904,\n" +
            "         \"vicinity\" : \"Block No. 9, Sector-17 A\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7026431,\n" +
            "               \"lng\" : 76.7940299\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7038971802915,\n" +
            "                  \"lng\" : 76.7954573302915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7011992197085,\n" +
            "                  \"lng\" : 76.79275936970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"cb3db68fe76b92b593b45f1c2482a2c88b9d0085\",\n" +
            "         \"name\" : \"Hotel Rajshree\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 4390,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/110360310953972788338/photos\\\"\\u003eHotel Rajshree\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAgk2WezIjIqIc7OIGBu8XrKks1FYGP0w0t9z445bU_2UHkdhWAl6Nnw80B8tNgcb3Ay2TKWjJ6-24bMB38f2enoZxgautpFo8DnyLBcIS31SVKo8ypJivwBbPKZjFb8xhEhARLcYWaOyCfDvm5Azvbjr2GhQe1JxfwuJNgl9s7SNzV6W6qXz3Sw\",\n" +
            "               \"width\" : 6832\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJ68fGTOzsDzkRCleZfhJydrw\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQ3V+3J Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQ3V+3J\"\n" +
            "         },\n" +
            "         \"rating\" : 3.9,\n" +
            "         \"reference\" : \"ChIJ68fGTOzsDzkRCleZfhJydrw\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"restaurant\", \"point_of_interest\", \"food\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 1470,\n" +
            "         \"vicinity\" : \"Plot No 181/45, Industrial and Business Park, Phase-1, Near Tribune Chowk, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.772004,\n" +
            "               \"lng\" : 76.795582\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7733553302915,\n" +
            "                  \"lng\" : 76.79689168029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7706573697085,\n" +
            "                  \"lng\" : 76.79419371970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"a43c41c79fa9cc078d9c2f9b49935783ffa7bbb7\",\n" +
            "         \"name\" : \"OYO 8424 Sunflower\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 428,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/102666973564428758425/photos\\\"\\u003eOYO 8424 Sunflower\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA33w7LxAJ43WBhkf_hRHPm20nteUA95vsZzuxmQIZz5zVwf15RW3A35KQzROkRkqKd_seAJuUpLba6nn02LGKmWh_MJwtKKoJ2p55FBLFS_w4zU6gLSwWRa79tZecBbhGEhCXrVq53cnYKX5V260XQ4hPGhTh5BGdJuWIBSNT0i9keUmJEWt5PA\",\n" +
            "               \"width\" : 761\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJZdfgdJzyDzkROPsBXJixV14\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"QQCW+R6 Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RQQCW+R6\"\n" +
            "         },\n" +
            "         \"rating\" : 3.4,\n" +
            "         \"reference\" : \"ChIJZdfgdJzyDzkROPsBXJixV14\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 126,\n" +
            "         \"vicinity\" : \"SCO No. 20, Nayagaon\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.735845,\n" +
            "               \"lng\" : 76.7961626\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.73720588029149,\n" +
            "                  \"lng\" : 76.7975285802915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7345079197085,\n" +
            "                  \"lng\" : 76.79483061970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/bar-71.png\",\n" +
            "         \"id\" : \"f1f0bd10c3ca2525e2acf81451d86d9c07c6d66d\",\n" +
            "         \"name\" : \"Score Lounge Bar Night Club Chandigarh\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : false\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 364,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/102460067622397720642/photos\\\"\\u003eScore Lounge Bar Night Club Chandigarh\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA05NdZPw6BunO0JL-aGqOWi1MQYgQJinuWKwJrhjkZYYkfPF3uuag_i2Uz7B69Uvvb77j2gbaB5Fb12cOcppXJ9zH-w1yYEhDzSmiT3SAY19XvYtMqo53TAkjUmj0YVGBEhA82NnADr0JyrFtygRZrLrXGhS06h7dRli3IEFjjaL5LIfuHgn6oA\",\n" +
            "               \"width\" : 960\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJWxfdgw3tDzkRI_GT7CncPuw\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQPW+8F Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQPW+8F\"\n" +
            "         },\n" +
            "         \"price_level\" : 2,\n" +
            "         \"rating\" : 3.8,\n" +
            "         \"reference\" : \"ChIJWxfdgw3tDzkRI_GT7CncPuw\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [\n" +
            "            \"night_club\",\n" +
            "            \"bar\",\n" +
            "            \"restaurant\",\n" +
            "            \"point_of_interest\",\n" +
            "            \"food\",\n" +
            "            \"establishment\"\n" +
            "         ],\n" +
            "         \"user_ratings_total\" : 480,\n" +
            "         \"vicinity\" : \"SCO 177, 178, Madhya Marg, Sector 8C, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7178945,\n" +
            "               \"lng\" : 76.7541468\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7191683802915,\n" +
            "                  \"lng\" : 76.75555973029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7164704197085,\n" +
            "                  \"lng\" : 76.75286176970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"8e70d2f5e9aaef9d7f3c84fff952ef4ffb2acf58\",\n" +
            "         \"name\" : \"Amara Hotel\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 3456,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/113396472721902745346/photos\\\"\\u003eVarun Kaul\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA9jRg7K2TgZgiFRQnnpvlrTDqa4emccylfioo5NaceRt_DFdNXN-_qpRJgM4xI2t5p8LoH6UuBkzfDsugUdpRFlRHPViwGkgp1idzeyeGHG7lnN9yGPv2sWyHrs5tDbAeEhC9KTE6xuxAf1hOzfajRgS5GhT7GO-k2LOwfSW3X4Tsc-ZKPxZG7Q\",\n" +
            "               \"width\" : 4608\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJFRsH7s3tDzkR4j4gxqUAuoo\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQ93+5M Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQ93+5M\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"ChIJFRsH7s3tDzkR4j4gxqUAuoo\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 805,\n" +
            "         \"vicinity\" : \"SCO 135-137, Sector 43-B, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.71149099999999,\n" +
            "               \"lng\" : 76.841825\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7128701302915,\n" +
            "                  \"lng\" : 76.84323173029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7101721697085,\n" +
            "                  \"lng\" : 76.8405337697085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"9a3b3f8890bbd240ff90be1edc04ee866381f42e\",\n" +
            "         \"name\" : \"Treebo Trend Dreamz\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 1836,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/100074076249251610440/photos\\\"\\u003eSafi Safi\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAal8bLUvUSMU_Ae8k7LDRQRwWMMcPVIfi5QPdHq9_Wgs6HYQa8xq0bwTnUQLKLpKu13izRx0MaK6F1gokkJiSgB8o6wOK4UG2aRXA6ieoQ_AYTxlrffYURVMW33010jPPEhBjeOd6E-7xi-u_DES31UjKGhSWkNJdnD1Jcgn-9AWOCJ14Ti8-Zw\",\n" +
            "               \"width\" : 3264\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJA4lbojuTDzkRkw0dugl2sno\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PR6R+HP Panchkula, Haryana, India\",\n" +
            "            \"global_code\" : \"8J2RPR6R+HP\"\n" +
            "         },\n" +
            "         \"rating\" : 3.9,\n" +
            "         \"reference\" : \"ChIJA4lbojuTDzkRkw0dugl2sno\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 307,\n" +
            "         \"vicinity\" : \"SCO 2, Chandigarh - Panchkula Road, Manimajra, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7205367,\n" +
            "               \"lng\" : 76.80070019999999\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7219462802915,\n" +
            "                  \"lng\" : 76.80214868029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.71924831970851,\n" +
            "                  \"lng\" : 76.7994507197085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"d26da867942c700281dd3e82b50c66a01951c9cb\",\n" +
            "         \"name\" : \"Mint Hotel Chandigarh\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 2908,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114478393818674303304/photos\\\"\\u003eMint Hotel Chandigarh\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA_mcqTxZ2PWKtW5p3iHEsMY6CgoESo-go3zaU-6Fa5uBbYtyTje6Ghag6lO5N2rTxxemaUAyHwkRSkHOMBjBBhLTbvXMQUM1dO7vH2sdjRmV-sfikkbcEmuMG1Jnn6oNlEhAwIAH6KLgtddB4bpyeEU2BGhSpmtdRdQaiRrOwLIS0-aMJHl71Ug\",\n" +
            "               \"width\" : 5168\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJRX_vRuDsDzkRj5lUdQKAyaQ\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PRC2+67 Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPRC2+67\"\n" +
            "         },\n" +
            "         \"rating\" : 3.6,\n" +
            "         \"reference\" : \"ChIJRX_vRuDsDzkRj5lUdQKAyaQ\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 256,\n" +
            "         \"vicinity\" : \"SCO 7, Block C\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.6602951,\n" +
            "               \"lng\" : 76.82204170000001\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.6616498802915,\n" +
            "                  \"lng\" : 76.82319203029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.6589519197085,\n" +
            "                  \"lng\" : 76.8204940697085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"f4dfca019938cd9ad245798e1e4689261d7b0741\",\n" +
            "         \"name\" : \"The Golden Palms Hotel & Spa\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 1075,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/106342085748349745422/photos\\\"\\u003eThe Golden Palms Hotel &amp; Spa\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAJMAXJkg0jQwuRaIAIQjCO6SFTDaRLOV6ecAaUX9MJfYbdR4X_yX-ZyilUkgTgzoY--CDrH8K7PV55a_Gcyx70qxfySVJOHSlUUJ9w1ALq-YewREvaNe-eIkZpbC1zfFvEhAzM3SxRRg2-Jvs4NczUQwMGhTcIFqNO3-rN7F1be-GkLLlu7veVA\",\n" +
            "               \"width\" : 2048\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJ_____67tDzkRvwSR_LSDxdU\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"MR6C+4R Zirakpur, Punjab, India\",\n" +
            "            \"global_code\" : \"8J2RMR6C+4R\"\n" +
            "         },\n" +
            "         \"rating\" : 3.9,\n" +
            "         \"reference\" : \"ChIJ_____67tDzkRvwSR_LSDxdU\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 74,\n" +
            "         \"vicinity\" : \"Paras Downtown Square Mall, Zirakpur\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.7215935,\n" +
            "               \"lng\" : 76.77148769999999\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.72302423029149,\n" +
            "                  \"lng\" : 76.7727610802915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.72032626970849,\n" +
            "                  \"lng\" : 76.77006311970848\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"a98db40d2812b3052f5d1672a7ad7766219c1f2b\",\n" +
            "         \"name\" : \"The TOY Hotel\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 3456,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/108492114240615662129/photos\\\"\\u003eThe TOY Hotel\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAyA8gVTqsC3RfAXRjKT69dAOIfUHY4w44COumYT2AIrrak-dr1oTYHKZBhT1F9fYU4cFhfQFlyG-iI7MalcjST7IbrYJ7p2Xrm8WgCs-0d7wNkN651lZp1BoACsLduXn5EhALPBB4rNS4KylM6TrhtHTeGhRCcLmpx5MncseENhwj6y6IX3mAkA\",\n" +
            "               \"width\" : 5184\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJVVVVFbPtDzkR53qXavoxIqc\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQCC+JH Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQCC+JH\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"ChIJVVVVFbPtDzkR53qXavoxIqc\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 690,\n" +
            "         \"vicinity\" : \"ZCC Road, SCO 165-167, Sector 34-A, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.727417,\n" +
            "               \"lng\" : 76.7498148\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7287246802915,\n" +
            "                  \"lng\" : 76.75110323029151\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7260267197085,\n" +
            "                  \"lng\" : 76.7484052697085\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"5d3594171bcd6ac721f092ad3cd58257b4b89699\",\n" +
            "         \"name\" : \"Hotel Royal Palace\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 2448,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114843572211852665894/photos\\\"\\u003eHotel Royal Palace\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAAZxt1fA52naaI9i41kurEZ4p_Z_bfB2n-3N2bpnvh-bfLKwGx3jax3vk3-oROaT2hu7Y_I-_yVXV6HGY13ZP2OTnPYqNSki2W6Xnqgt5UtracEIUepV7u5Dj4tUtIjyS3EhCZ8V68ngClGdRlaP2yNx6vGhSXiHsOogzCcjV5knGZETSWgl2hpw\",\n" +
            "               \"width\" : 3264\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJi4VD8EnsDzkRbfaG4vKSl4s\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PPGX+XW Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPPGX+XW\"\n" +
            "         },\n" +
            "         \"rating\" : 3.4,\n" +
            "         \"reference\" : \"ChIJi4VD8EnsDzkRbfaG4vKSl4s\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 72,\n" +
            "         \"vicinity\" : \"Plot no.81-82, Sector 42 B, Attawa\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.701465,\n" +
            "               \"lng\" : 76.791158\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.7027266302915,\n" +
            "                  \"lng\" : 76.7925774802915\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.7000286697085,\n" +
            "                  \"lng\" : 76.78987951970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"57259ce2a4d34a8815713796a9dd7e5dc2a0d158\",\n" +
            "         \"name\" : \"The Fern Residency, Chandigarh\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 1836,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/113340388116965254532/photos\\\"\\u003eIndian Food Made Easy\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRZAAAAdSUvZ0osZZ1gIrszIo6s4rWwR1yU4m1vBUsgVV_Te9--f7lyjdI3Jt0D5CdEPlk_pgnYkqPVOYNi1Xq2ihSQ09ICWzdNlDDWXwnct3rsjnBBZM4s9DdAhV1y7sD6TpZBEhDXxx8iVZFk0BCez4fdy56LGhSXj5CR9nIuj1E-J_vlsSHqn0RJDA\",\n" +
            "               \"width\" : 3264\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJjdz9YfLsDzkRc3Ui0KTVfxM\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQ2R+HF Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQ2R+HF\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"ChIJjdz9YfLsDzkRc3Ui0KTVfxM\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 628,\n" +
            "         \"vicinity\" : \"28/8 Phase II, Industrial & Business Park, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.70060289999999,\n" +
            "               \"lng\" : 76.7884191\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.70199013029149,\n" +
            "                  \"lng\" : 76.78983008029149\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.69929216970849,\n" +
            "                  \"lng\" : 76.78713211970849\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png\",\n" +
            "         \"id\" : \"a4e980dad5f895847362304e815fcb72802d7e41\",\n" +
            "         \"name\" : \"Hotel KLG Starlite\",\n" +
            "         \"opening_hours\" : {\n" +
            "            \"open_now\" : true\n" +
            "         },\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 834,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/111227317311467958756/photos\\\"\\u003eHotel KLG Starlite\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAA3DvIMPiaga8Y02Z-H-TjmX5uRuOjnpmIZANgqDSPs4293Zfe4KNci2Vzg2Mowvjw17Bg9wHli3nCKGmYrhMnrsL3Sv2kkr8jidXw-jFv0ZiY7eDiqzQwe5E4wGBK7Bq1EhCunw4k3ob6qN5i_e9_t63fGhR_w1mNd0OVf-pc66HsgvmNEJUa7A\",\n" +
            "               \"width\" : 834\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJc7rxAfPsDzkR0cEbtYvppis\",\n" +
            "         \"plus_code\" : {\n" +
            "            \"compound_code\" : \"PQ2Q+69 Chandigarh, India\",\n" +
            "            \"global_code\" : \"8J2RPQ2Q+69\"\n" +
            "         },\n" +
            "         \"rating\" : 4,\n" +
            "         \"reference\" : \"ChIJc7rxAfPsDzkR0cEbtYvppis\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"lodging\", \"point_of_interest\", \"establishment\" ],\n" +
            "         \"user_ratings_total\" : 1198,\n" +
            "         \"vicinity\" : \"Plot No. 51, Tribune Chowk, Phase-2, Industrial Area Phase I, Chandigarh\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"geometry\" : {\n" +
            "            \"location\" : {\n" +
            "               \"lat\" : 30.3781788,\n" +
            "               \"lng\" : 76.7766974\n" +
            "            },\n" +
            "            \"viewport\" : {\n" +
            "               \"northeast\" : {\n" +
            "                  \"lat\" : 30.40811699999999,\n" +
            "                  \"lng\" : 76.81297289999999\n" +
            "               },\n" +
            "               \"southwest\" : {\n" +
            "                  \"lat\" : 30.3361391,\n" +
            "                  \"lng\" : 76.74188079999999\n" +
            "               }\n" +
            "            }\n" +
            "         },\n" +
            "         \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png\",\n" +
            "         \"id\" : \"ec1bda35db6966fb145dcb04bbcb23f9bde3555a\",\n" +
            "         \"name\" : \"Ambala\",\n" +
            "         \"photos\" : [\n" +
            "            {\n" +
            "               \"height\" : 414,\n" +
            "               \"html_attributions\" : [\n" +
            "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/117334640138766730955/photos\\\"\\u003eSunil Padhi\\u003c/a\\u003e\"\n" +
            "               ],\n" +
            "               \"photo_reference\" : \"CmRaAAAADZcLcD8x16Oqaw1n5Roxpmi7Sej8tyDK2uJegJDWWu_PwHmtB5yvDZX6gYtf70_6F8pBHP94HVkDj6aGEXdkU5x3gmkjhj7VPfUvSIHr6ngUSN5P9A16nl_JaU8w9hDvEhAdTaovZxGzlTPA7O-2RKGkGhQ49exoayr1jOWOpE9GxhSch-2D6g\",\n" +
            "               \"width\" : 552\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJEW8eQiq2DzkRFI0l9ymK0us\",\n" +
            "         \"reference\" : \"ChIJEW8eQiq2DzkRFI0l9ymK0us\",\n" +
            "         \"scope\" : \"GOOGLE\",\n" +
            "         \"types\" : [ \"locality\", \"political\" ],\n" +
            "         \"vicinity\" : \"Ambala\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"status\" : \"OK\"\n" +
            "}";
    PlacesName(double longitude,double latitude){
        this.latitude=latitude;
        this.longitude=longitude;
        url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=30.6746879,76.8262542&radius=50000&key=AIzaSyDNCuwXUgnWQ2zopS2Hy4hkHgOx20Q13MQ";
        getLink();
    }
    private void getLink()
    {
        try {
            link = new URL(url);
        }
        catch (MalformedURLException e)
        {
            Log.e("MalFormed URl","Check Url",e);
            //link=null;
        }
    }
    private void setres()
    {

    }

    public String names()  {
        String t="";
        try {
            JSONObject req1 = new JSONObject(res);
            JSONArray result=  req1.getJSONArray("results");
            for(int i=0;i<result.length();i++)
            {
                JSONObject current =result.getJSONObject(i);
                String s = current.getString("name");
                t=t+" "+s;
            }
            t=t+link.getPath()+link.getQuery();
            return t;
        }
        catch (JSONException e)
        {
            String h="Error1";
            Log.e("Placename","parsing",e);
            return h;
        }
    }
}
