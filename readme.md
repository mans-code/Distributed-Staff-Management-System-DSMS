## Requirements
 
# Use ClinicManagement implementation with server replication system
  * server process replication
  * reliable group communication
  * failure detection
  * leader election

# Server process replication
* One leader and two backups
* Database synchronization for each request

# Reliable communication
* FIFO broadcast using UDP
* Lost messages recovery
	
#  Failure detection
* Subsystem in which processes check each other.
* Remove failed process from group.
* If leader fails, elect new leader.
* Use bully algorithm to elect a new leader.

# Leader process receives client instructions and replicate them
* Receive response from replicas
* Single response to the client
* Make broadcast reliable
  * Sequentialization
  * Timeouts


## Implementation 
# Client:
* Create and send request to the front end system using CORBA e.g create Doctor or Nurse Record.
# Front End:
* Receive client request, wrap the request and sequence number  in a message object, and send the message to replicate manager to handle the request using UDP. Then wait for the replicate manager to return a result. Finally, return the result to the client.
# Replica manager:
Selected replica that communicates with frontend and synchronizes backup replicas.
* Receive messages from FrontEnd, client request.

* Execute the messages in order, using the sequence inside the message. 
In case of lost messages, Replica manager send “message lost request” to FrontEnd. The message must have a sequence number of the missing message. Finally wait for the missing message before handling any more messages .   

* Send a message that has the new system status to the backups using UDP (with each message Replicate manager attach the     	sequence number received from FrontEnd for FIFO broadcast)
  ** For Example, when the  Replica manager receive create doctor request it creates the new doctor record and build a message that has the doctor record and sequence number received by the FrontEnd, and send this message to replicate backups. 
* Wait for replicate backups to return a result.
* Return a result to FrontEnd.
 
# Replica backups:
* Receive updates from Replica manager.
* Verifies ordering based on FIFO broadcast (First update execute before the second).
* Applies changes to local database
* Return a result to replicate the manager.
