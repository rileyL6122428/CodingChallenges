import DateUtils from '../../src/utils/DateUtils.js';

describe("Describe DateUtils", () => {
  describe("#monthDayYear", () => {
    it("should return the proper date representation corresponding to provided integer time", () => {
      expect(DateUtils.monthDayYear(0)).toEqual("1/1/1970");
      expect(DateUtils.monthDayYear(123456789123)).toEqual("11/29/1973");
    });
  });
});
