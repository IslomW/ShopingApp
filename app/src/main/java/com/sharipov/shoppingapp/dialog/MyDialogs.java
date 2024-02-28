package com.sharipov.shoppingapp.dialog;

import android.app.FragmentManager;


public class MyDialogs {

    public static void showNoticeDialog(FragmentManager fragmentManager, String message){
        NoticeDialog dialog = NoticeDialog.getInstance(message);
        dialog.show(fragmentManager, "message");
    }

}
