/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: aidl/ILicenseResultListener.aidl
 */
package com.ucr.micuenca.lib.licensing;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
public interface ILicenseResultListener extends IInterface
{
/** Local-side IPC implementation stub class. */
abstract class Stub extends Binder implements com.ucr.micuenca.lib.licensing.ILicenseResultListener
{
private static final String DESCRIPTOR = "com.android.vending.licensing.ILicenseResultListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an ILicenseResultListener interface,
 * generating a proxy if needed.
 */
public static com.ucr.micuenca.lib.licensing.ILicenseResultListener asInterface(IBinder obj)
{
if ((obj==null)) {
return null;
}
IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.ucr.micuenca.lib.licensing.ILicenseResultListener))) {
return ((com.ucr.micuenca.lib.licensing.ILicenseResultListener)iin);
}
return new com.ucr.micuenca.lib.licensing.ILicenseResultListener.Stub.Proxy(obj);
}
public IBinder asBinder()
{
return this;
}
public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_verifyLicense:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
this.verifyLicense(_arg0, _arg1, _arg2);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.ucr.micuenca.lib.licensing.ILicenseResultListener
{
private IBinder mRemote;
Proxy(IBinder remote)
{
mRemote = remote;
}
public IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void verifyLicense(int responseCode, String signedData, String signature) throws RemoteException
{
Parcel _data = Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(responseCode);
_data.writeString(signedData);
_data.writeString(signature);
mRemote.transact(Stub.TRANSACTION_verifyLicense, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_verifyLicense = (IBinder.FIRST_CALL_TRANSACTION + 0);
}
void verifyLicense(int responseCode, String signedData, String signature) throws RemoteException;
}
