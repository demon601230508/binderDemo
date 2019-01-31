package com.cloud.test;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class CallBackProxy extends Binder {
    public static final String descriptor = "com.cloud.test.callback";
    public static final int test = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

    @Override
    protected boolean onTransact(int code,  @NonNull Parcel data,  @Nullable Parcel reply, int flags) throws RemoteException {
        Log.d("TestAc", "onTransact:::"+code);
        switch (code) {
            case test:
                data.enforceInterface(descriptor);
                Log.d("TestAc", "onTransact:::???");
                break;
        }
        return super.onTransact(code, data, reply, flags);
    }
}
