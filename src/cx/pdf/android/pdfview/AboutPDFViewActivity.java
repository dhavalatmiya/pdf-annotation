package cx.pdf.android.pdfview;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import cx.pdf.android.pdfview.R;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Displays "About..." info.
 */
public class AboutPDFViewActivity extends Activity {
	
	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		this.setContentView(R.layout.about);
		WebView v = (WebView)this.findViewById(R.id.webview_about);
		android.content.res.Resources resources = this.getResources();
		InputStream aboutHtmlInputStream = new BufferedInputStream(resources.openRawResource(R.raw.about));
		String aboutHtml = null;
		try {
			aboutHtml = StreamUtils.readStringFully(aboutHtmlInputStream);
			aboutHtmlInputStream.close();
			aboutHtmlInputStream = null;
			resources = null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		v.loadData(
				aboutHtml,
				"text/html",
				"utf-8"
			);
	}
}
