let StorageFormats = {
  idMap: (entityList, formatEntity) => {
    let idMap = {};

    entityList.forEach((entity) => {
      idMap[entity.id] = (formatEntity) ? formatEntity(entity) : entity;
    });

    return idMap;
  }
};

export default StorageFormats;
