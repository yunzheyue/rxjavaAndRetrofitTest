package com.example.app5;

import java.util.List;

public class News {


    @Override
    public String toString() {
        return "News{" +
                "Head=" + Head +
                ", Summary=" + Summary +
                ", DataSource=" + DataSource +
                '}';
    }

    /**
     * Head : {"DataKey":"00-00-00","DEXType":"1","DataObjects":"WB_EMF_FaultRepairList","DEXTime":"2018/10/15 11:15:32.581","DEXVersion":"1.7.2.707","Version":"1.7.2.707"}
     * Summary : {"DEXResult":"1","StatusCode":"100","Message":"请求数据成功完成"}
     * DataSource : {"Tables":[{"Name":"emf_faultrepair","Key":"ID","Datas":[{"ID":"90816b6d-0971-4ecf-86b3-fa156dc0a731","FaultCode":"EMF2018082210325537","ReportObjectCompany":"10570bed-54ff-11e5-8ec1-64006a4cb35a","OrganiseUnitName":"福州鰲峰加油站","Address":"北京市东城区","ReportObject":"001001","ReportObjectType":"9","ReportObjectName":"建筑墙","FaultReasonName":"","PlanRepairDate":"2018/8/24 10:04:02","PlanRepairEndDate":"2018/8/25 10:04:02","RepairPerson":"cyf_1","RepairPersonName":"陈永富","RepairDate":"","RepairResult":"","Status":"4"}]}]}
     */


    private HeadBean Head;
    private SummaryBean Summary;
    private DataSourceBean DataSource;

    public HeadBean getHead() {
        return Head;
    }

    public void setHead(HeadBean Head) {
        this.Head = Head;
    }

    public SummaryBean getSummary() {
        return Summary;
    }

    public void setSummary(SummaryBean Summary) {
        this.Summary = Summary;
    }

    public DataSourceBean getDataSource() {
        return DataSource;
    }

    public void setDataSource(DataSourceBean DataSource) {
        this.DataSource = DataSource;
    }

    public static class HeadBean {

        @Override
        public String toString() {
            return "HeadBean{" +
                    "DataKey='" + DataKey + '\'' +
                    ", DEXType='" + DEXType + '\'' +
                    ", DataObjects='" + DataObjects + '\'' +
                    ", DEXTime='" + DEXTime + '\'' +
                    ", DEXVersion='" + DEXVersion + '\'' +
                    ", Version='" + Version + '\'' +
                    '}';
        }

        /**
         * DataKey : 00-00-00
         * DEXType : 1
         * DataObjects : WB_EMF_FaultRepairList
         * DEXTime : 2018/10/15 11:15:32.581
         * DEXVersion : 1.7.2.707
         * Version : 1.7.2.707
         */

        private String DataKey;
        private String DEXType;
        private String DataObjects;
        private String DEXTime;
        private String DEXVersion;
        private String Version;

        public String getDataKey() {
            return DataKey;
        }

        public void setDataKey(String DataKey) {
            this.DataKey = DataKey;
        }

        public String getDEXType() {
            return DEXType;
        }

        public void setDEXType(String DEXType) {
            this.DEXType = DEXType;
        }

        public String getDataObjects() {
            return DataObjects;
        }

        public void setDataObjects(String DataObjects) {
            this.DataObjects = DataObjects;
        }

        public String getDEXTime() {
            return DEXTime;
        }

        public void setDEXTime(String DEXTime) {
            this.DEXTime = DEXTime;
        }

        public String getDEXVersion() {
            return DEXVersion;
        }

        public void setDEXVersion(String DEXVersion) {
            this.DEXVersion = DEXVersion;
        }

        public String getVersion() {
            return Version;
        }

        public void setVersion(String Version) {
            this.Version = Version;
        }
    }

    public static class SummaryBean {
        @Override
        public String toString() {
            return "SummaryBean{" +
                    "DEXResult='" + DEXResult + '\'' +
                    ", StatusCode='" + StatusCode + '\'' +
                    ", Message='" + Message + '\'' +
                    '}';
        }

        /**
         * DEXResult : 1
         * StatusCode : 100
         * Message : 请求数据成功完成
         */


        private String DEXResult;
        private String StatusCode;
        private String Message;

        public String getDEXResult() {
            return DEXResult;
        }

        public void setDEXResult(String DEXResult) {
            this.DEXResult = DEXResult;
        }

        public String getStatusCode() {
            return StatusCode;
        }

        public void setStatusCode(String StatusCode) {
            this.StatusCode = StatusCode;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String Message) {
            this.Message = Message;
        }
    }

    public static class DataSourceBean {
        private List<TablesBean> Tables;

        public List<TablesBean> getTables() {
            return Tables;
        }

        public void setTables(List<TablesBean> Tables) {
            this.Tables = Tables;
        }

        public static class TablesBean {

            @Override
            public String toString() {
                return "TablesBean{" +
                        "Name='" + Name + '\'' +
                        ", Key='" + Key + '\'' +
                        ", Datas=" + Datas +
                        '}';
            }

            /**
             * Name : emf_faultrepair
             * Key : ID
             * Datas : [{"ID":"90816b6d-0971-4ecf-86b3-fa156dc0a731","FaultCode":"EMF2018082210325537","ReportObjectCompany":"10570bed-54ff-11e5-8ec1-64006a4cb35a","OrganiseUnitName":"福州鰲峰加油站","Address":"北京市东城区","ReportObject":"001001","ReportObjectType":"9","ReportObjectName":"建筑墙","FaultReasonName":"","PlanRepairDate":"2018/8/24 10:04:02","PlanRepairEndDate":"2018/8/25 10:04:02","RepairPerson":"cyf_1","RepairPersonName":"陈永富","RepairDate":"","RepairResult":"","Status":"4"}]
             */

            private String Name;
            private String Key;
            private List<DatasBean> Datas;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getKey() {
                return Key;
            }

            public void setKey(String Key) {
                this.Key = Key;
            }

            public List<DatasBean> getDatas() {
                return Datas;
            }

            public void setDatas(List<DatasBean> Datas) {
                this.Datas = Datas;
            }

            public static class DatasBean {

                @Override
                public String toString() {
                    return "DatasBean{" +
                            "ID='" + ID + '\'' +
                            ", FaultCode='" + FaultCode + '\'' +
                            ", ReportObjectCompany='" + ReportObjectCompany + '\'' +
                            ", OrganiseUnitName='" + OrganiseUnitName + '\'' +
                            ", Address='" + Address + '\'' +
                            ", ReportObject='" + ReportObject + '\'' +
                            ", ReportObjectType='" + ReportObjectType + '\'' +
                            ", ReportObjectName='" + ReportObjectName + '\'' +
                            ", FaultReasonName='" + FaultReasonName + '\'' +
                            ", PlanRepairDate='" + PlanRepairDate + '\'' +
                            ", PlanRepairEndDate='" + PlanRepairEndDate + '\'' +
                            ", RepairPerson='" + RepairPerson + '\'' +
                            ", RepairPersonName='" + RepairPersonName + '\'' +
                            ", RepairDate='" + RepairDate + '\'' +
                            ", RepairResult='" + RepairResult + '\'' +
                            ", Status='" + Status + '\'' +
                            '}';
                }

                /**
                 * ID : 90816b6d-0971-4ecf-86b3-fa156dc0a731
                 * FaultCode : EMF2018082210325537
                 * ReportObjectCompany : 10570bed-54ff-11e5-8ec1-64006a4cb35a
                 * OrganiseUnitName : 福州鰲峰加油站
                 * Address : 北京市东城区
                 * ReportObject : 001001
                 * ReportObjectType : 9
                 * ReportObjectName : 建筑墙
                 * FaultReasonName :
                 * PlanRepairDate : 2018/8/24 10:04:02
                 * PlanRepairEndDate : 2018/8/25 10:04:02
                 * RepairPerson : cyf_1
                 * RepairPersonName : 陈永富
                 * RepairDate :
                 * RepairResult :
                 * Status : 4
                 */

                private String ID;
                private String FaultCode;
                private String ReportObjectCompany;
                private String OrganiseUnitName;
                private String Address;
                private String ReportObject;
                private String ReportObjectType;
                private String ReportObjectName;
                private String FaultReasonName;
                private String PlanRepairDate;
                private String PlanRepairEndDate;
                private String RepairPerson;
                private String RepairPersonName;
                private String RepairDate;
                private String RepairResult;
                private String Status;

                public String getID() {
                    return ID;
                }

                public void setID(String ID) {
                    this.ID = ID;
                }

                public String getFaultCode() {
                    return FaultCode;
                }

                public void setFaultCode(String FaultCode) {
                    this.FaultCode = FaultCode;
                }

                public String getReportObjectCompany() {
                    return ReportObjectCompany;
                }

                public void setReportObjectCompany(String ReportObjectCompany) {
                    this.ReportObjectCompany = ReportObjectCompany;
                }

                public String getOrganiseUnitName() {
                    return OrganiseUnitName;
                }

                public void setOrganiseUnitName(String OrganiseUnitName) {
                    this.OrganiseUnitName = OrganiseUnitName;
                }

                public String getAddress() {
                    return Address;
                }

                public void setAddress(String Address) {
                    this.Address = Address;
                }

                public String getReportObject() {
                    return ReportObject;
                }

                public void setReportObject(String ReportObject) {
                    this.ReportObject = ReportObject;
                }

                public String getReportObjectType() {
                    return ReportObjectType;
                }

                public void setReportObjectType(String ReportObjectType) {
                    this.ReportObjectType = ReportObjectType;
                }

                public String getReportObjectName() {
                    return ReportObjectName;
                }

                public void setReportObjectName(String ReportObjectName) {
                    this.ReportObjectName = ReportObjectName;
                }

                public String getFaultReasonName() {
                    return FaultReasonName;
                }

                public void setFaultReasonName(String FaultReasonName) {
                    this.FaultReasonName = FaultReasonName;
                }

                public String getPlanRepairDate() {
                    return PlanRepairDate;
                }

                public void setPlanRepairDate(String PlanRepairDate) {
                    this.PlanRepairDate = PlanRepairDate;
                }

                public String getPlanRepairEndDate() {
                    return PlanRepairEndDate;
                }

                public void setPlanRepairEndDate(String PlanRepairEndDate) {
                    this.PlanRepairEndDate = PlanRepairEndDate;
                }

                public String getRepairPerson() {
                    return RepairPerson;
                }

                public void setRepairPerson(String RepairPerson) {
                    this.RepairPerson = RepairPerson;
                }

                public String getRepairPersonName() {
                    return RepairPersonName;
                }

                public void setRepairPersonName(String RepairPersonName) {
                    this.RepairPersonName = RepairPersonName;
                }

                public String getRepairDate() {
                    return RepairDate;
                }

                public void setRepairDate(String RepairDate) {
                    this.RepairDate = RepairDate;
                }

                public String getRepairResult() {
                    return RepairResult;
                }

                public void setRepairResult(String RepairResult) {
                    this.RepairResult = RepairResult;
                }

                public String getStatus() {
                    return Status;
                }

                public void setStatus(String Status) {
                    this.Status = Status;
                }
            }
        }
    }
}
