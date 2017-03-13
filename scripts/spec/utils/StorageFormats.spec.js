import StorageFormats from '../../src/utils/storageFormats.js'

describe("StorageFormats", () => {
  let entities;

  beforeEach(() => {
    entities = [
      { "id": 3, name: "MOCK_ENTITY_3" },
      { "id": 2, name: "MOCK_ENTITY_2" },
      { "id": 1, name: "MOCK_ENTITY_1" },
    ];
  });

  describe("#idMap", () => {
    it("returns a map with ids pointing to the supplied ids", () => {
      let idMap = StorageFormats.idMap(entities);

      expect(idMap[3]).toBe(entities[0]);
      expect(idMap[2]).toBe(entities[1]);
      expect(idMap[1]).toBe(entities[2]);
    });
  });

  describe("#idList", () => {
    it("returns a list of ids", () => {
      let idList = StorageFormats.idList(entities);

      expect(idList.length).toEqual(3);
      entities.forEach((entity) => {
        expect(idList).toContain(entity.id);
      });
    });
  })
});
