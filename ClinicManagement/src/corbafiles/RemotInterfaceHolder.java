package corbafiles;

/**
* RemotInterfaceApp/RemotInterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IDLFile.idl
* Thursday, June 16, 2016 6:51:02 AM EDT
*/

public final class RemotInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public corbafiles.RemotInterface value = null;

  public RemotInterfaceHolder ()
  {
  }

  public RemotInterfaceHolder (corbafiles.RemotInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corbafiles.RemotInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corbafiles.RemotInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corbafiles.RemotInterfaceHelper.type ();
  }

}