package pages;

import DAO.Emp99_DAO;
import POJO.Emp99_pojo;

public class ConnectToDatabase {

	public static void main(String[] args) throws Exception {
		
		
		//CREATE new entry using stored procedure
		try (Emp99_DAO d = new Emp99_DAO()) {
			Emp99_pojo p = new Emp99_pojo("f_name", "f_surname", 600.60f, 2, "job6", "manager4");
			int count = d.add_SP_emp99(p);
			System.out.println("added new entry : count is " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		//READ : to display all row values of table
//		try (Emp99_DAO d = new Emp99_DAO()) {
//			List<Emp99_pojo> selectEmpList99 = d.selectEmpList99();
//
//			for (Emp99_pojo emp : selectEmpList99) {
//				System.out.println(emp);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//READ : to display row with specific employee number
//		try (Emp99_DAO d = new Emp99_DAO()) {
//			List<Emp99_pojo> selectEmpList99 = d.selectEmpList99("b_name");
//			for (Emp99_pojo emp : selectEmpList99) {
//				System.out.println(emp);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
//		//READ : to display row with department number equal to 2
//			try (Emp99_DAO d = new Emp99_DAO()) {
//				List<Emp99_pojo> selectEmpList99 = d.selectEmpList99(2);
//				for (Emp99_pojo emp : selectEmpList99) {
//					System.out.println(emp);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
	
//		//READ : to display row with deptno= 2 and mgr="manager2"
//		try (Emp99_DAO d = new Emp99_DAO()) {
//			List<Emp99_pojo> selectEmpList99 = d.selectEmpList99(2,"manager2");
//			for (Emp99_pojo emp : selectEmpList99) {
//				System.out.println(emp);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//CREATE
//		try (Emp99_DAO d = new Emp99_DAO()) {
//			Emp99_pojo p = new Emp99_pojo("e_name", "e_surname", 500.50f, 3, "job5", "manager5");
//			int count = d.addEmp99(p);
//			System.out.println("added new entry : count is " + count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}	

//		//UPDATE
//		try(Emp99_DAO d= new Emp99_DAO()){
//			int count = d.updateSalary("a_name", 999.9f);
//			System.out.println("emp update : count : "+count);
//		
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//DELETE
//		try(Emp99_DAO d= new Emp99_DAO()){
//			int count = d.deleteEmp99("e_name");
//			System.out.println("emp deleted : count : "+count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		

	}
}
