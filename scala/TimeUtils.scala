import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

object TimeUtils extends Logging {

  /**
    * get today's date string in pattern format
    *
    * @param pattern
    * @return
    */
  def getTodayDateStr(pattern: String = "yyyyMMdd"): String = {
    getStrFromDate(getTodayDate, pattern)
  }

  /**
    * get today date
    *
    * @return
    */
  def getTodayDate: Date = {
    Calendar.getInstance().getTime
  }

  /**
    * get shifted date string in pattern format
    *
    * @param baseDateStr
    * @param days
    * @param weeks
    * @param months
    * @param years
    * @param pattern
    * @return
    */
  def getShiftedDateStr(baseDateStr: String = getTodayDateStr(), seconds: Int = 0, minutes: Int = 0, hours: Int = 0, days: Int = 0, weeks: Int = 0, months: Int = 0, years: Int = 0, pattern: String = "yyyyMMdd"): String = {
    getStrFromDate(getShiftedDate(
      baseDate = getDateFromStr(baseDateStr, pattern),
      seconds = seconds,
      minutes = minutes,
      hours = hours,
      days = days,
      weeks = weeks,
      months = months,
      years = years
    ), pattern)
  }

  /**
    * string to date
    *
    * @param dateStr
    * @param pattern
    * @return
    */
  def getDateFromStr(dateStr: String, pattern: String = "yyyyMMdd"): Date = {
    val sdf = new SimpleDateFormat(pattern)
    sdf.parse(dateStr)
  }

  /**
    * date to string
    *
    * @param date
    * @param pattern
    * @return
    */
  def getStrFromDate(date: Date, pattern: String = "yyyyMMdd"): String = {
    val sdf = new SimpleDateFormat(pattern)
    sdf.format(date)
  }

  /**
    * get shifted date
    *
    * @param baseDate
    * @param days
    * @param weeks
    * @param months
    * @param years
    * @return
    */
  def getShiftedDate(baseDate: Date = getTodayDate, seconds: Int = 0, minutes: Int = 0, hours: Int = 0, days: Int = 0, weeks: Int = 0, months: Int = 0, years: Int = 0): Date = {
    val cal: Calendar = Calendar.getInstance()
    cal.setTime(baseDate)
    cal.add(Calendar.SECOND, seconds)
    cal.add(Calendar.MINUTE, minutes)
    cal.add(Calendar.HOUR, hours)
    cal.add(Calendar.DATE, days)
    cal.add(Calendar.DATE, 7 * weeks)
    cal.add(Calendar.MONTH, months)
    cal.add(Calendar.YEAR, years)
    cal.getTime
  }

}

