package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.BillService;
import com.example.bookstoreproject.services.RoleService;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admindemo")
public class AdminDemoController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BillService billService;

	@GetMapping("home")
	public String loginAdmin() {
		return "admin/adminIndex";
	}

	@GetMapping("adminUser")
	public String loginAdminUser(ModelMap model) {
		List<UserEntity> listUser = (List<UserEntity>) userService.findAll();
		model.addAttribute("users", listUser);
		return "admin/adminUserManager";
	}

	@GetMapping("adminUserStatistics")
	public String adminUserStatistics(ModelMap model) {
		List<UserEntity> listUser = (List<UserEntity>) userService.findAll();

		java.util.Date date = new java.util.Date();
		Calendar daynow = Calendar.getInstance();
		daynow.setTime(date);

		List<Calendar> listCal = new ArrayList<Calendar>();

		for (int i = 0; i < listUser.size(); i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(listUser.get(i).getCreateDate());
			listCal.add(cal);
		}

//		for (Calendar calendar : listCal) {
//			System.out.println("danh sách các ngày trong db :" + calendar.get(Calendar.DAY_OF_MONTH));
//		}

		// các ngày trong tuần
		int Cn = 0;
		int T7 = 0;
		int T6 = 0;
		int T5 = 0;
		int T4 = 0;
		int T3 = 0;
		int T2 = 0;

		switch (daynow.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					Cn += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T7 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T6 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 4)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 5)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 6)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;
				}

			}
			break;
		case 2:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;
				}

			}
			break;
		case 3:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;
				}

			}
			break;
		case 4:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += 1;

				}

				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += 1;

				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;

				}

			}
			break;
		case 5:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += 1;
				}

				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;
				}

			}
			break;
		case 6:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T6 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 4)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;
				}

			}
			break;
		case 7:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T7 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T6 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 4)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += 1;
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 5)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += 1;
				}

			}
			break;
		default:
			System.err.println();
		}

		int[] ls = { T2, T3, T4, T5, T6, T7, Cn };

		// thống kê tháng

		int th1 = 0, th2 = 0, th3 = 0, th4 = 0, th5 = 0, th6 = 0, th7 = 0, th8 = 0, th9 = 0, th10 = 0, th11 = 0, th12 = 0;
		switch (daynow.get(Calendar.MONTH)) {
		case 0:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}

			}
			break;
		case 1:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}

			}
			break;
		case 2:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}

			}
			break;
		case 3:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}

			}
			break;
		case 4:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 5:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 6:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 7:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 8:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 9:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th10 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 9)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 10:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th11 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th10 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 9)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 10)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;
		case 11:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th12 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th11 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th10 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 9)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 10)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += 1;
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 11)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += 1;
				}
			}
			break;

		default:
			break;
		}

//		int[] lsMonth = { 2, 10, 45, 52, 90, 55, 72, 89, 99, 100, 111, 222 };
		int[] lsMonth = { th1, th2, th3, th4, th5, th6, th7, th8, th9, th10, th11, th12 };

		model.addAttribute("users", listUser);
		model.addAttribute("ls", ls);
		model.addAttribute("lsMonth", lsMonth);

//		System.out.println("c là :" + daynow.get(Calendar.DAY_OF_WEEK));
//		System.out.println("ngày trước hiện tại là :" + (daynow.get(Calendar.DAY_OF_MONTH) - 1));
//		System.out.println("list là :" + ls);
//		
		

		return "admin/adminUserStatistics";
	}

	@GetMapping("adminProfitStatistics")
	public String adminProfitStatistics(ModelMap model) {
		List<BillEntity> listBill = (List<BillEntity>) billService.findAll();

		java.util.Date date = new java.util.Date();
		Calendar daynow = Calendar.getInstance();
		daynow.setTime(date);

		List<Calendar> listCal = new ArrayList<Calendar>();

		for (int i = 0; i < listBill.size(); i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(listBill.get(i).getCreateDate());
			listCal.add(cal);
		}

		for (Calendar calendar : listCal) {
			System.out.println("danh sách các ngày trong db :" + calendar.get(Calendar.DAY_OF_MONTH));
		}

		// các ngày trong tuần
		int Cn = 0;
		int T7 = 0;
		int T6 = 0;
		int T5 = 0;
		int T4 = 0;
		int T3 = 0;
		int T2 = 0;

		switch (daynow.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					Cn += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 4)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 5)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 6)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 2:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 3:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 4:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += listBill.get(i).getTotalMoney();

				}

				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += listBill.get(i).getTotalMoney();

				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();

				}

			}
			break;
		case 5:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += listBill.get(i).getTotalMoney();
				}

				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 6:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 4)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 7:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == daynow.get(Calendar.DAY_OF_MONTH)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 1)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 2)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 3)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 4)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.DAY_OF_MONTH) == (daynow.get(Calendar.DAY_OF_MONTH) - 5)
						&& listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					T2 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		default:
			System.err.println();
		}

		int[] lsDay = { T2, T3, T4, T5, T6, T7, Cn };

		// thống kê tháng

		int th1 = 0, th2 = 0, th3 = 0, th4 = 0, th5 = 0, th6 = 0, th7 = 0, th8 = 0, th9 = 0, th10 = 0, th11 = 0, th12 = 0;
		switch (daynow.get(Calendar.MONTH)) {
		case 0:
			for (int i = 0; i < listCal.size(); i++) {
				if (listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 1:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 2:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 3:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}

			}
			break;
		case 4:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 5:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 6:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 7:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 8:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 9:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th10 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 9)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 10:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th11 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th10 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 9)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 10)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;
		case 11:
			for (int i = 0; i < listCal.size(); i++) {
				if ( listCal.get(i).get(Calendar.MONTH) == daynow.get(Calendar.MONTH)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th12 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 1)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th11 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 2)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th10 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 3)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th9 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 4)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th8 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 5)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th7 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 6)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th6 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 7)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th5 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 8)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th4 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 9)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th3 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 10)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th2 += listBill.get(i).getTotalMoney();
				}
				if (listCal.get(i).get(Calendar.MONTH) == (daynow.get(Calendar.MONTH) - 11)
						&& listCal.get(i).get(Calendar.YEAR) == daynow.get(Calendar.YEAR)) {
					th1 += listBill.get(i).getTotalMoney();
				}
			}
			break;

		default:
			break;
		}


		int[] lsMonth = { th1, th2, th3, th4, th5, th6, th7, th8, th9, th10, th11, th12 };

		model.addAttribute("listbill", listBill);
		model.addAttribute("lsDay", lsDay);
		model.addAttribute("lsMonth", lsMonth);
		
		for (int j : lsDay) {
			System.out.println("danh sách ngày : " +j);
		}
		for (int j : lsMonth) {
			System.out.println("danh sách tháng : " +j);
		}
		return "admin/adminProfitStatistics";
	}

	@GetMapping("adminFeedback")
	public String loginAdminFeedback() {
		return "admin/adminFeedbackManager";
	}

	@GetMapping("adminUser/formAddUser")
	public String loginAdminFormAdd() {
		return "admin/adminFormAdd";
	}

	@ModelAttribute("user")
	public UserEntity userEntity() {
		return new UserEntity();
	}

	@GetMapping("adminUser/formEditUser")
	public String loginAdminFormEditUser() {
		return "admin/adminFormEditUser";
	}

	@PostMapping("adminUser/formAddUser")
	public String addUserNow(@ModelAttribute("user") UserEntity entity) {
		RoleEntity roleEntity = roleService.findByRoleName("ROLE_ADMIN");
		entity.setRoles(Arrays.asList(roleEntity));
		userService.saveReg(entity);

		return "redirect:/admin/adminUser/formAddUser?success";
	}

	@PostMapping("/checkEmail")
	@ResponseBody
	public String check(@RequestParam String email) {
		return (userService.findByEmail(email) != null ? "exist" : "ok");
	}
}
