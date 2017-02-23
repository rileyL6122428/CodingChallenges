var DateUtils = {
  monthDayYear: (integerTime) => {
    let date = new Date(integerTime);
    return (date.getMonth() + 1) + "/" + date.getDate() + "/" + date.getFullYear();
  }
};

export default DateUtils;
