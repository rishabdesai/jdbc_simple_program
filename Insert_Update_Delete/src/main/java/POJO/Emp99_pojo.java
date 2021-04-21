package POJO;

public class Emp99_pojo {
	private String empno;
	private String ename;
	private float sal;
	private int deptno;
	private String job;
	private String mgr;

	public Emp99_pojo() {
	}

	public Emp99_pojo(String empno, String ename, float sal, int deptno, String job, String mgr) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
		this.job = job;
		this.mgr = mgr;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	@Override
	public String toString() {
		return String.format("%-4s\t%-10s\t%-10.2f\t%-2d\t%-2s\t%-4s\n", empno, ename, sal, deptno, job, mgr);
	}

}
