
FACELIST  module . 
An openmrs module that provides a  functionality of uploading images for patients faces without installing any extra feature.. 
it stores the images in the openmrs applicationDataDirectory in a folder called FACE_images associated with the patientId. the images uploaded are registered in the database in a table called "facelist_multipart"using the patient id

it can then return a list of all the patient faces with the patient name and id in a jquery table  that can allow u to search for a patient and and can click to view the full face ,forming a face aLbum .

the module can only uplodd one image per patient , and wen a new omage is uploaded for a given who already has one, the old one is by default overidden. 

its is dependent on the Legacy UI .

the module has links on the Administrator page and on the patient Dashbord .

the Jquery Validator API makes sure u cant not upload an empty image or wothout electing a name. 