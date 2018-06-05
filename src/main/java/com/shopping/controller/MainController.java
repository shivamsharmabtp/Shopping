package com.shopping.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.shopping.model.RoundRangeData;
import com.shopping.services.MapSerializer;
import com.shopping.services.SpecialMap;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {
  //  @Autowired
  //  UserDao userDao;


    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public String defaultPage() {

		/*ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This is default page!");
		model.setViewName("ProductManagement");
*/
        return "ProductManagement";

    }

	/*@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}
	@RequestMapping(value={ "/signUp" }, method=RequestMethod.GET)
	public ModelAndView addMenuItem(@ModelAttribute("user") User user){
	
		userDao.saveUser(user);
		return new ModelAndView("signUp");
	}
	@RequestMapping(value = { "/signUp" }, method = RequestMethod.GET)
    public String signUpFormProcess(User user,BindingResult bindingResult,HttpServletRequest request) {
    	if(request.getUserPrincipal() != null)
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    	if (bindingResult.hasErrors()) {
            return "signUp";
        }
    	String password = user.getPassword();
    	userDao.saveUser(user);
        return "redirect:/productList";
		
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.POST)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}*/

    @RequestMapping(value = "/zone/settings/ranged/update", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> zoneSettingsRangedUpdate(
            @RequestBody RoundRangeData data
    ) throws IOException {

        Map<String, Object> model = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(SpecialMap.class, new MapSerializer());
        mapper.registerModule(module);

        String serialized = mapper.writeValueAsString(data);
       // return serialized;
        model.put("request", serialized);
        model.put("success",true);

        return new ResponseEntity<Map<String, Object>>(model, HttpStatus.OK);
    }

    @RequestMapping(value="/modifiedPolygon",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<JSONObject> modifiedPolygon(@RequestBody JSONObject data, HttpServletRequest request, ModelMap model) {
        return new ResponseEntity<JSONObject>(data,HttpStatus.OK);
    }
}