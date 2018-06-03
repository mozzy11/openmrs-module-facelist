
FACELIST  module . 
An open mrs module that provides a basic functionality of uploading images for patients faces without installing any extra feature.. 
it sores the images in the openmrs applicationDataDirectory in a folder called FACE_images

it can then return a list of all thhe patient faces with the patient name and id in a jquery table  that can allow u to search for a patient and and can click to view the full face.

it is dependent on the Legacy UI .

the module has links on the Administrator page and on the patient Dashbord .

the Jquery Validator API makes sure u cant not upload an empty image or wothout electing a name. 