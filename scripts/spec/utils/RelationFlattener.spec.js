import RelationFlattener from '../../src/utils/relationFlattener.js';

describe("RelationFlattener", () => {
  describe("#flatList", () => {
    it("produces a list of unique objects based on a relation when duplicate related objects exist", () => {
      let relatedObj1 = { name: "RELATED_OBJ_1", id: 1};
      let relatedObj2 = { name: "RELATED_OBJ_2", id: 2 };
      let obj1 = { name: "OBJ1", relation: [relatedObj1, relatedObj2] };
      let obj2 = { name: "OBJ2", relation: [relatedObj1, relatedObj2] };

      let relatedObjects = RelationFlattener.flatList([obj1, obj2], "relation");

      expect(relatedObjects.length).toEqual(2);
      expect(relatedObjects).toContain(relatedObj1);
      expect(relatedObjects).toContain(relatedObj2);
    });

    it("produces a list containing all related objects when no duplicate relations exist", () => {
      let relatedObj1 = { name: "RELATED_OBJ_1", id: 1};
      let relatedObj2 = { name: "RELATED_OBJ_2", id: 2 };
      let relatedObj3 = { name: "RELATED_OBJ_3", id: 3 };
      let obj1 = { name: "OBJ1", relation: [relatedObj3] };
      let obj2 = { name: "OBJ2", relation: [relatedObj2] };
      let obj3 = { name: "OBJ3", relation: [relatedObj1] };

      let relatedObjects = RelationFlattener.flatList([obj1, obj2, obj3], "relation");

      expect(relatedObjects.length).toEqual(3);
      expect(relatedObjects).toContain(relatedObj1);
      expect(relatedObjects).toContain(relatedObj2);
      expect(relatedObjects).toContain(relatedObj3);
    });
  });
});
