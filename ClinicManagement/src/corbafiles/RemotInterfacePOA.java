package corbafiles;


/**
* RemotInterfaceApp/RemotInterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IDLFile.idl
* Thursday, June 16, 2016 6:51:02 AM EDT
*/

public abstract class RemotInterfacePOA extends org.omg.PortableServer.Servant
 implements corbafiles.RemotInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createDRecord", new java.lang.Integer (0));
    _methods.put ("createNRecord", new java.lang.Integer (1));
    _methods.put ("getRecordCount", new java.lang.Integer (2));
    _methods.put ("editRecord", new java.lang.Integer (3));
    _methods.put ("transferRecord", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // RemotInterfaceApp/RemotInterface/createDRecord
       {
         String managerId = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String address = in.read_string ();
         String phone = in.read_string ();
         String specialization = in.read_string ();
         String location = in.read_string ();
         String $result = null;
         $result = this.createDRecord (managerId, firstName, lastName, address, phone, specialization, location);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // RemotInterfaceApp/RemotInterface/createNRecord
       {
         String managerId = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String designation = in.read_string ();
         String status = in.read_string ();
         String statusDate = in.read_string ();
         String $result = null;
         $result = this.createNRecord (managerId, firstName, lastName, designation, status, statusDate);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // RemotInterfaceApp/RemotInterface/getRecordCount
       {
         String managerId = in.read_string ();
         int recordType = in.read_long ();
         String $result = null;
         $result = this.getRecordCount (managerId, recordType);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // RemotInterfaceApp/RemotInterface/editRecord
       {
         String managerId = in.read_string ();
         String recordID = in.read_string ();
         String fieldName = in.read_string ();
         String newValue = in.read_string ();
         String $result = null;
         $result = this.editRecord (managerId, recordID, fieldName, newValue);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // RemotInterfaceApp/RemotInterface/transferRecord
       {
         String managerID = in.read_string ();
         String recordID = in.read_string ();
         String remoteClinicServerName = in.read_string ();
         String $result = null;
         $result = this.transferRecord (managerID, recordID, remoteClinicServerName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:RemotInterfaceApp/RemotInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public RemotInterface _this() 
  {
    return RemotInterfaceHelper.narrow(
    super._this_object());
  }

  public RemotInterface _this(org.omg.CORBA.ORB orb) 
  {
    return RemotInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class RemotInterfacePOA
