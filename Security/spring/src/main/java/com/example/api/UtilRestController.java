package com.example.api;


import com.example.domain.Util;
import com.example.repository.UtilRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(value = "utils", description = "Utils")
@RestController
@CrossOrigin
@RequestMapping("utils")
public class UtilRestController {
    @Autowired
    UtilRepository utilRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Util> postUtils(@RequestBody List<Util> utils) {
        List<Util> created = utilRepository.save(utils);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Util> getUtils() {
        List<Util> utils = utilRepository.findAll();
        return utils;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Util getUtil(@PathVariable Long id) {
        Util util = utilRepository.findOne(id);
        return util;
    }

    /*
    @RequestMapping(method = RequestMethod.PUT)
    public List<Util> putUtils(@RequestBody List<Util> utils) {
        List<Util> updated = utilRepository.save(utils);
        return updated;
    }
    */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Util putUtil(@PathVariable Long id,
                                @RequestBody Util util) {
        Util found = utilRepository.findOne(id);
        Util updated = null;

        if (found != null) {
            updated = utilRepository.save(util);
        }

        return updated;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUtils() {
        utilRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUtil(@PathVariable Long id) {
        //TODO: handling unfound id


        // and then delete a specific id
        utilRepository.delete(id);
    }

    //--------------------------------------------------------------------------------
    // Date/Calendar
    // excerpt : http://www.devblog.kr/r/8y0gFPAvJ2j8MWIVVXucyP9uYvQegfSVbY5XNCMe1
    //TODO: LocalDate, LocalTime, Instant, Duration, Period
    @RequestMapping(value = "currentDate", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> currentDate() {
        int nYear, nMonth, nDay;
        Map<String, String> map = new HashMap<String, String>();

        Calendar calendar = new GregorianCalendar(Locale.KOREA);
        nYear = calendar.get(Calendar.YEAR);
        nMonth = calendar.get(Calendar.MONTH) + 1;
        nDay = calendar.get(Calendar.DAY_OF_MONTH);
        String cal = nYear + "-" + nMonth + "-" + nDay;
        map.put("cal", cal);

        SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년MM월dd일");
        String date = fm1.format(new Date());
        map.put("date", date);

        SimpleDateFormat fm2 = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
        String date2 = fm2.format(new Date());
        map.put("date2", date2);

        return map;
    }

    @RequestMapping(value = "addDate", method = RequestMethod.GET)
    @ResponseBody
    public String addDate() {
        String date;

        Calendar calendar = new GregorianCalendar(Locale.KOREA);
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1); // -1
        calendar.add(Calendar.MONTH, 1); // -1
        calendar.add(Calendar.DAY_OF_MONTH, 1); // -1
        calendar.add(Calendar.HOUR, 1); // -1

        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = fm.format(calendar.getTime());
        return date;
    }

    @RequestMapping(value = "diffDate", method = RequestMethod.GET)
    @ResponseBody
    public long diffDate() {
        String start = "2015-04-01";
        String end = "2015-05-05";
        long diffDays = 0;

        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDate = fm.parse(start);
            Date endDate = fm.parse(end);

            long diff = endDate.getTime() - startDate.getTime();
            diffDays = diff / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return diffDays;
    }

    @RequestMapping(value = "dayOfWeek", method = RequestMethod.GET)
    @ResponseBody
    public String dayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        String strWeek = null;

        int nWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch(nWeek) {
            case 1:
                strWeek = "Sunday";
                break;
            case 2:
                strWeek = "Monday";
                break;
            case 3:
                strWeek = "Tuesday";
                break;
            case 4:
                strWeek = "Wednesday";
                break;
            case 5:
                strWeek = "Thursday";
                break;
            case 6:
                strWeek = "Friday";
                break;
            case 7:
                strWeek = "Saturday";
                break;
        }

        return strWeek;
    }

    @RequestMapping(value = "diffSystemTime", method = RequestMethod.GET)
    @ResponseBody
    public double diffSystemtime() {
        double diff = 0;

        try {
            long time1 = System.currentTimeMillis();
            Thread.sleep(1500);
            long time2 = System.currentTimeMillis();

            diff = (time2 - time1)/1000.0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return diff;
    }

    @RequestMapping(value = "timezone", method = RequestMethod.GET)
    @ResponseBody
    public String timezone() {
        String tzStr = null;
        String[] availableIds = TimeZone.getAvailableIDs();
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul");
        Calendar calendar = Calendar.getInstance(timeZone);

        tzStr = "" + calendar.get(Calendar.YEAR) + "-" +
                (calendar.get(Calendar.MONTH) + 1) + "-" +
                calendar.get(Calendar.DAY_OF_MONTH) + " " +
                calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" +
                calendar.get(Calendar.SECOND);
        return tzStr;
    }

    @RequestMapping(value = "longDate", method = RequestMethod.GET)
    @ResponseBody
    public String longDate() {
        String longDate = null;

        Date current = new Date();
        long longCurr = current.getTime();

        Date today = new Date(longCurr);
        DateFormat fm = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREA);
        longDate = fm.format(today);

        return longDate;
    }
}
