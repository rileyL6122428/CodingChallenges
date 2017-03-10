import StorageFormats from './storageFormats.js';

let RelationFlattener = {
  flatten: (entityList, relationName) => {
    let flattenedRelation = {};

    entityList.forEach((entity) => {
      let relatedEntities = entity[relationName];
      Object.assign(flattenedRelation, StorageFormats.idMap(relatedEntities);
    });

    return flattenedRelation;
  }
};

export RelationFlattener;
