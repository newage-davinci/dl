package com.dawailelo;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ImageMan {

	public String bmptostring(Bitmap selectedImage) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		byte[] byteArray = stream.toByteArray();
		String strBase64 = Base64.encodeToString(byteArray, 0);
		return strBase64;
	}

	public Bitmap stringtobmp(String strBase64) {
		byte[] decodedString = Base64.decode(strBase64, Base64.DEFAULT);
		Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,
				decodedString.length);
		return decodedByte;
	}
	
}
