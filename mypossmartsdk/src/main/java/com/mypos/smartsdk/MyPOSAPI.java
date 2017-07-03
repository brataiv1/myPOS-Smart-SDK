package com.mypos.smartsdk;

import android.app.Activity;
import android.content.Intent;


public class MyPOSAPI {

    /**
     * Takes care of building the intent and opening the payment activity
     *
     * @param activity    the activity whose context will be used to start the payment activity
     * @param payment     a {@link MyPOSPayment} object with payment-related data
     * @param requestCode the request code used later to distinguish
     */
    public static void openPaymentActivity(Activity activity, MyPOSPayment payment, int requestCode) {
        Intent myposIntent = new Intent(MyPOSUtil.PAYMENT_CORE_ENTRY_POINT_INTENT);

        myposIntent.putExtra(MyPOSUtil.INTENT_TRANSACTION_AMOUNT, payment.getProductAmount());
        myposIntent.putExtra(MyPOSUtil.INTENT_TRANSACTION_FOREIGN_TRANSACTION_ID, payment.getForeignTransactionId());
        myposIntent.putExtra(MyPOSUtil.INTENT_TRANSACTION_REQUEST_CODE, MyPOSUtil.TRANSACTION_TYPE_PAYMENT);

        activity.startActivityForResult(myposIntent, requestCode);
    }

    /**
     * Takes care of building the intent and opening the payment activity for a refund transaction
     *
     * @param activity    the activity whose context will be used to start the payment activity
     * @param refund      a {@link MyPOSPayment} object with payment-related data
     * @param requestCode the request code used later to distinguish the type of transaction that has completed
     */
    public static void openRefundActivity(Activity activity, MyPOSRefund refund, int requestCode) {
        Intent myposIntent = new Intent(MyPOSUtil.PAYMENT_CORE_ENTRY_POINT_INTENT);

        myposIntent.putExtra(MyPOSUtil.INTENT_TRANSACTION_AMOUNT, refund.getRefundAmount());
        myposIntent.putExtra(MyPOSUtil.INTENT_TRANSACTION_FOREIGN_TRANSACTION_ID, refund.getForeignTransactionId());
        myposIntent.putExtra(MyPOSUtil.INTENT_TRANSACTION_REQUEST_CODE, MyPOSUtil.TRANSACTION_TYPE_REFUND);

        activity.startActivityForResult(myposIntent, requestCode);
    }
}