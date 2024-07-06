
package com.tienda.service;

import org.springframework.web.multipart.MultipartFile;


public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //creacion de la coneccion con el firebase
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-ace5c.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-ace5c-firebase-adminsdk-82rht-0a9b57efca.json";



}
