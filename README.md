
FACELIST  module . 
An openmrs module that provides a  functionality of uploading images for patients faces without installing any extra feature.. 
it stores the images in the openmrs applicationDataDirectory in a folder called FACE_images associated with the patientId. the images uploaded are registered in the database in a table called "facelist_multipart"using the patient id

it can then return a list of all the patient faces with the patient name and id in a jquery table  that can allow u to search for a patient and and can click to view the full face ,forming a face aLbum .

the module can only upload one image per patient , and when a new image is uploaded for a given Patient who already have one, the old one is by default overidden. 

its is dependent on the Legacy UI and runs on openmrs paltform 2+.

the module has links on the Administrator page and on the patient Dashbord .

the Jquery Validator API makes sure u cant not upload an empty image or without selecting a Patientname. 