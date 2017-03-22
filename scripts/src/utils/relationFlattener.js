import StorageFormats from './storageFormats.js';

let RelationFlattener = {
  flatList(entityList, relationName) {
    let flattenedRelation = {};

    entityList.forEach((entity) => {
      let relatedEntities = entity[relationName];
      Object.assign(flattenedRelation, StorageFormats.idMap(relatedEntities));
    });

    return Object.values(flattenedRelation);
  }
};

export default RelationFlattener;
