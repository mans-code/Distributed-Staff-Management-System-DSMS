### Requirements
 
 #  Use ClinicManagement implementation with server replication system
  * server process replication
  * reliable group communication
  * failure detection
  * leader election

## Server process replication
* One leader and two backups
* Database synchronization for each request

## Reliable communication
* FIFO broadcast using UDP
* Lost messages recovery
	
## Failure detection
* Subsystem in which processes check each other.
* Remove failed process from group.
* If leader fails, elect new leader.
* Use bully algorithm to elect a new leader.

## Leader process receives client instructions and replicate them
* Receive response from replicas
* Single response to the client
* Make broadcast reliable
  * Sequentialization
  * Timeouts


#Distributed Staff Management System (DSMS) using Java RMI

* 3 clinics
* 3 servers (ClinicServer)
  * servers will maintain records
  * 2 types of records: Nurse and Doctors
  * records have unique IDs ex
    * DR10000 NR29299 (NR/DR [0-9]5*)

## DoctorRecord contains the following fields:
* First name
* Last name
* Address
* Phone
* Specialization (e.g. surgeon, orthopaedic, etc)
* Location (mtl, lvl, ddo)

## A NurseRecord contains the following fields:
• First name
• Last name
• Designation (junior/senior)
• Status (active/terminated)
• Status Date (active or terminated date)

* every record will be stored in a list with the same first letter of last name
* a hashmap will keep all letters
* nurses and doctors in the same list
* Each server maintains a log of all operations in text file ( what, who, when )

## Users 
* ManagerClient
* managerID (MTL/DDO/LVL[0-9]*4)
* system will identify manager by it's id and direct the actions to managers server
* ManagerClient keep a log of the actions they performed

## System
* createDRecord (firstName, lastName, address, phone, specialization, location)
  * server returns if success
* createNRecord (firstName, lastName, designation, status, statusDate)
  * same
* getRecordCounts (recordType)
  * using UDP/IP gets the number of records from each clinic
* editRecord (recordID, fieldName, newValue)
  * edits based on id and returns success/fail message. 
  * The fields that should be allowed to change are address, phone and location (for DoctorRecord), and designation, status and status date (for NurseRecord).

#Implementation
You should design the ClinicServer maximizing concurrency. In other words, use proper
synchronization that allows multiple clinic manager to perform operations for the same or
different records at the same time.
http://stackoverflow.com/questions/19541582/storing-and-retrieving-arraylist-values-from-hashmap

#Test Cases

* Test - creating, editing and counting records
  * Case 1: 
  * Case 2: 
* Test - FIFO
  * Case 1: 
  * Case 2:
* Test - server leader election
  * Case 1:
  * Case 2:
