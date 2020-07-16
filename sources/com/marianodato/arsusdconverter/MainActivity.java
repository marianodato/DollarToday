package com.marianodato.arsusdconverter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    double ARS = 0.0d;

    private class CallAPI extends AsyncTask<String, String, JSONObject> {
        private CallAPI() {
        }

        public JSONObject doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            JSONObject response = new JSONObject();
            try {
                HttpURLConnection urlConnection2 = (HttpURLConnection) new URL(params[0]).openConnection();
                if (urlConnection2.getResponseCode() == 200) {
                    response = new JSONObject(readStream(urlConnection2.getInputStream()));
                }
                if (urlConnection2 != null) {
                    urlConnection2.disconnect();
                }
            } catch (Exception e) {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            } catch (Throwable th) {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                throw th;
            }
            return response;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[SYNTHETIC, Splitter:B:11:0x0020] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0035 A[SYNTHETIC, Splitter:B:23:0x0035] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String readStream(java.io.InputStream r7) {
            /*
                r6 = this;
                r1 = 0
                java.lang.StringBuffer r3 = new java.lang.StringBuffer
                r3.<init>()
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0040, all -> 0x0032 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0040, all -> 0x0032 }
                r4.<init>(r7)     // Catch:{ IOException -> 0x0040, all -> 0x0032 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x0040, all -> 0x0032 }
                java.lang.String r0 = ""
            L_0x0012:
                java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x001c, all -> 0x003d }
                if (r0 == 0) goto L_0x0028
                r3.append(r0)     // Catch:{ IOException -> 0x001c, all -> 0x003d }
                goto L_0x0012
            L_0x001c:
                r4 = move-exception
                r1 = r2
            L_0x001e:
                if (r1 == 0) goto L_0x0023
                r1.close()     // Catch:{ IOException -> 0x0039 }
            L_0x0023:
                java.lang.String r4 = r3.toString()
                return r4
            L_0x0028:
                if (r2 == 0) goto L_0x0042
                r2.close()     // Catch:{ IOException -> 0x002f }
                r1 = r2
                goto L_0x0023
            L_0x002f:
                r4 = move-exception
                r1 = r2
                goto L_0x0023
            L_0x0032:
                r4 = move-exception
            L_0x0033:
                if (r1 == 0) goto L_0x0038
                r1.close()     // Catch:{ IOException -> 0x003b }
            L_0x0038:
                throw r4
            L_0x0039:
                r4 = move-exception
                goto L_0x0023
            L_0x003b:
                r5 = move-exception
                goto L_0x0038
            L_0x003d:
                r4 = move-exception
                r1 = r2
                goto L_0x0033
            L_0x0040:
                r4 = move-exception
                goto L_0x001e
            L_0x0042:
                r1 = r2
                goto L_0x0023
            */
            throw new UnsupportedOperationException("Method not decompiled: com.marianodato.arsusdconverter.MainActivity.CallAPI.readStream(java.io.InputStream):java.lang.String");
        }

        public void onPostExecute(JSONObject response) {
            if (!response.isNull("rates")) {
                try {
                    MainActivity.this.ARS = response.getJSONObject("rates").getDouble(MainActivity.this.getResources().getString(C0517R.string.textTo));
                } catch (JSONException e) {
                }
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callApi();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo((int) C0517R.mipmap.dolar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView((int) C0517R.layout.activity_main);
    }

    private void callApi() {
        String urlString = getResources().getString(C0517R.string.app_url) + "?app_id=" + getResources().getString(C0517R.string.app_id);
        new CallAPI().execute(new String[]{urlString});
    }

    public void invert(View view) {
        TextView textFrom = (TextView) findViewById(C0517R.C0519id.textViewFrom);
        TextView textTo = (TextView) findViewById(C0517R.C0519id.textViewTo);
        TextView textResult = (TextView) findViewById(C0517R.C0519id.textViewResult);
        String aux = (String) textFrom.getText();
        textFrom.setText(textTo.getText());
        textTo.setText(aux);
        textResult.setText("");
    }

    public void convertAmount(View view) {
        TextView textResult = (TextView) findViewById(C0517R.C0519id.textViewResult);
        if (this.ARS != 0.0d) {
            double amount = Double.valueOf(((EditText) findViewById(C0517R.C0519id.editText1)).getText().toString()).doubleValue();
            if (getResources().getString(C0517R.string.textFrom).equals(((TextView) findViewById(C0517R.C0519id.textViewFrom)).getText().toString())) {
                textResult.setText(String.valueOf(this.ARS * amount));
            } else {
                textResult.setText(String.valueOf(amount / this.ARS));
            }
        } else {
            textResult.setText(getResources().getString(C0517R.string.error));
            callApi();
        }
    }
}
