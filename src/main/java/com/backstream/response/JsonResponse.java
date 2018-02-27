package com.backstream.response;

import java.util.List;

public class JsonResponse {

    private List<LaureatesBean> laureates;

    public List<LaureatesBean> getLaureates() {
        return laureates;
    }

    public void setLaureates(List<LaureatesBean> laureates) {
        this.laureates = laureates;
    }

    public static class LaureatesBean {
        /**
         * id : 1
         * firstname : Wilhelm Conrad
         * surname : Röntgen
         * born : 1845-03-27
         * died : 1923-02-10
         * bornCountry : Prussia (now Germany)
         * bornCountryCode : DE
         * bornCity : Lennep (now Remscheid)
         * diedCountry : Germany
         * diedCountryCode : DE
         * diedCity : Munich
         * gender : male
         * prizes : [{"year":"1901","category":"physics","share":"1","motivation":"\"in recognition of the extraordinary services he has rendered by the discovery of the remarkable rays subsequently named after him\"","affiliations":[{"name":"Munich University","city":"Munich","country":"Germany"}]}]
         */

        private String id;
        private String firstname;
        private String surname;
        private String born;
        private String died;
        private String bornCountry;
        private String bornCountryCode;
        private String bornCity;
        private String diedCountry;
        private String diedCountryCode;
        private String diedCity;
        private String gender;
        private List<PrizesBean> prizes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }

        public String getDied() {
            return died;
        }

        public void setDied(String died) {
            this.died = died;
        }

        public String getBornCountry() {
            return bornCountry;
        }

        public void setBornCountry(String bornCountry) {
            this.bornCountry = bornCountry;
        }

        public String getBornCountryCode() {
            return bornCountryCode;
        }

        public void setBornCountryCode(String bornCountryCode) {
            this.bornCountryCode = bornCountryCode;
        }

        public String getBornCity() {
            return bornCity;
        }

        public void setBornCity(String bornCity) {
            this.bornCity = bornCity;
        }

        public String getDiedCountry() {
            return diedCountry;
        }

        public void setDiedCountry(String diedCountry) {
            this.diedCountry = diedCountry;
        }

        public String getDiedCountryCode() {
            return diedCountryCode;
        }

        public void setDiedCountryCode(String diedCountryCode) {
            this.diedCountryCode = diedCountryCode;
        }

        public String getDiedCity() {
            return diedCity;
        }

        public void setDiedCity(String diedCity) {
            this.diedCity = diedCity;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public List<PrizesBean> getPrizes() {
            return prizes;
        }

        public void setPrizes(List<PrizesBean> prizes) {
            this.prizes = prizes;
        }

        public static class PrizesBean {
            /**
             * year : 1901
             * category : physics
             * share : 1
             * motivation : "in recognition of the extraordinary services he has rendered by the discovery of the remarkable rays subsequently named after him"
             * affiliations : [{"name":"Munich University","city":"Munich","country":"Germany"}]
             */

            private String year;
            private String category;
            private String share;
            private String motivation;
            private List<AffiliationsBean> affiliations;

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getShare() {
                return share;
            }

            public void setShare(String share) {
                this.share = share;
            }

            public String getMotivation() {
                return motivation;
            }

            public void setMotivation(String motivation) {
                this.motivation = motivation;
            }

            public List<AffiliationsBean> getAffiliations() {
                return affiliations;
            }

            public void setAffiliations(List<AffiliationsBean> affiliations) {
                this.affiliations = affiliations;
            }

            public static class AffiliationsBean {
                /**
                 * name : Munich University
                 * city : Munich
                 * country : Germany
                 */

                private String name;
                private String city;
                private String country;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }
            }
        }
    }
}
