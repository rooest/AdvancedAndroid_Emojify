package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by omeraksu on 6.06.2018.
 */

class Emojifier {

    static void detectFaces(Context context,Bitmap bitmap) {

        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faceArray = faceDetector.detect(frame);


        if (faceArray.size() > 0) {
            Log.d(Emojifier.class.getSimpleName()," number of detected  faces : " + faceArray.size());
        } else {
            Toast.makeText(context,"Faces can't found",Toast.LENGTH_SHORT).show();
        }

        faceDetector.release();
    }
}
