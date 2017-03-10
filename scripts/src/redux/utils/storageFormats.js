let StorageFormats = {
  idMap: (entityList, formatEntity) => {
    let idMap = {};

    entityList.forEach((entity) => {
      idMap[entity.id] = (formatEntity) ? formatEntity(entity) : entity;
    });

    return idMap;
  },

  idList: (entityList) => {
    return entityList.map((entity) => { return entity.id; });
  }
};

export default StorageFormats;
