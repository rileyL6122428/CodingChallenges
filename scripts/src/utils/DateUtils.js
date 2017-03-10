var DateUtils = {
  monthDayYear: (integerTime) => {
    let date = new Date(integerTime);
    return (date.getUTCMonth() + 1) + "/" + date.getUTCDate() + "/" + date.getUTCFullYear();
  }
};

export default DateUtils;
