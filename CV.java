import java.util.Objects;

public class CV {
    public String generateHtml() {
        String html = """
                <!DOCTYPE html>
                <html lang=\"vi\">
                <head>
                    <meta charset=\"UTF-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
                    <title>CV - NGÔ THỊ THANH NHÀN</title>
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                        }

                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f0f0f0;
                            color: #333;
                            line-height: 1.4;
                        }

                        .cv-container {
                            max-width: 900px;
                            margin: 0 auto;
                            background-color: white;
                            display: flex;
                            min-height: 100vh;
                        }

                        /* Left Column */
                        .left-column {
                            width: 35%;
                            background-color: #1e3a8a;
                            color: white;
                            padding: 40px 30px;
                        }

                        .profile-picture {
                            text-align: center;
                            margin-bottom: 40px;
                        }

                        .profile-picture img {
                            width: 120px;
                            height: 120px;
                            border-radius: 50%;
                            border: 2px solid white;
                            object-fit: cover;
                        }

                        .section {
                            margin-bottom: 35px;
                        }

                        .section-title {
                            font-size: 14px;
                            font-weight: bold;
                            text-transform: uppercase;
                            margin-bottom: 15px;
                            border-bottom: 1px solid white;
                            padding-bottom: 8px;
                        }

                        .contact-item {
                            display: flex;
                            align-items: center;
                            margin-bottom: 12px;
                            font-size: 13px;
                        }

                        .contact-icon {
                            width: 16px;
                            margin-right: 12px;
                            text-align: center;
                            font-size: 14px;
                        }

                        .education-item {
                            margin-bottom: 25px;
                        }

                        .education-date {
                            font-size: 11px;
                            color: #cbd5e1;
                            margin-bottom: 8px;
                        }

                        .education-school {
                            font-size: 12px;
                            font-weight: bold;
                            text-transform: uppercase;
                            margin-bottom: 8px;
                        }

                        .education-details {
                            font-size: 12px;
                            margin-left: 0;
                            list-style: none;
                        }

                        .education-details li {
                            margin-bottom: 4px;
                        }

                        .skill-item {
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            margin-bottom: 10px;
                            font-size: 13px;
                        }

                        .skill-name {
                            flex: 1;
                        }

                        .skill-rating {
                            color: #fbbf24;
                            font-size: 12px;
                        }

                        .language-item {
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            margin-bottom: 10px;
                            font-size: 13px;
                        }

                        .language-name {
                            flex: 1;
                        }

                        .language-level {
                            color: #cbd5e1;
                            font-size: 12px;
                        }

                        /* Right Column */
                        .right-column {
                            width: 65%;
                            padding: 50px 40px;
                            background-color: white;
                        }

                        .name {
                            font-size: 28px;
                            font-weight: bold;
                            text-transform: uppercase;
                            color: #1e3a8a;
                            margin-bottom: 8px;
                            letter-spacing: 1px;
                        }

                        .title {
                            font-size: 16px;
                            text-transform: uppercase;
                            color: #374151;
                            margin-bottom: 40px;
                            font-weight: normal;
                        }

                        .section-divider {
                            height: 1px;
                            background-color: #d1d5db;
                            margin: 30px 0;
                        }

                        .section-title-right {
                            font-size: 14px;
                            font-weight: bold;
                            text-transform: uppercase;
                            color: #1e3a8a;
                            margin-bottom: 15px;
                            letter-spacing: 0.5px;
                        }

                        .objective-text {
                            font-size: 13px;
                            line-height: 1.6;
                            text-align: justify;
                            color: #374151;
                        }

                        .experience-item {
                            margin-bottom: 30px;
                        }

                        .experience-header {
                            display: flex;
                            justify-content: space-between;
                            align-items: flex-start;
                            margin-bottom: 12px;
                        }

                        .experience-company {
                            font-weight: bold;
                            font-size: 14px;
                            color: #1e3a8a;
                            text-transform: uppercase;
                        }

                        .experience-position {
                            font-size: 13px;
                            color: #374151;
                            margin-top: 2px;
                            font-weight: normal;
                        }

                        .experience-date {
                            font-size: 11px;
                            color: #6b7280;
                            text-align: right;
                        }

                        .experience-responsibilities {
                            font-size: 12px;
                            line-height: 1.5;
                            margin-left: 0;
                            list-style: none;
                            color: #374151;
                        }

                        .experience-responsibilities li {
                            margin-bottom: 8px;
                        }

                        .skills-list {
                            font-size: 13px;
                            list-style: none;
                            color: #374151;
                        }

                        .skills-list li {
                            margin-bottom: 6px;
                        }

                        /* Responsive */
                        @media (max-width: 768px) {
                            .cv-container {
                                flex-direction: column;
                            }
                            
                            .left-column, .right-column {
                                width: 100%;
                            }
                        }
                    </style>
                </head>
                <body>
                    <div class=\"cv-container\">
                        <!-- Left Column -->
                        <div class=\"left-column\">
                            <!-- Profile Picture -->
                            <div class=\"profile-picture\">
                                <img src=\"profile.jpg\" alt=\"Profile Picture\" onerror=\"this.src='data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTIwIiBoZWlnaHQ9IjEyMCIgdmlld0JveD0iMCAwIDEyMCAxMjAiIGZpbGw9Im5vbmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjxyZWN0IHdpZHRoPSIxMjAiIGhlaWdodD0iMTIwIiByeD0iNjAiIGZpbGw9IiNmM2Y0ZjYiLz4KPGNpcmNsZSBjeD0iNjAiIGN5PSI0NSIgcj0iMjAiIGZpbGw9IiM5Y2EzYWYiLz4KPHBhdGggZD0iTTMwIDkwQzMwIDc1LjY0IDQ0LjY0IDY0IDYwIDY0Qzc1LjM2IDY0IDkwIDc1LjY0IDkwIDkwVjEwMEgzMFY5MFoiIGZpbGw9IiM5Y2EzYWYiLz4KPC9zdmc+Cg=='\"/>
                            </div>

                            <!-- Contact Information -->
                            <div class=\"section\">
                                <div class=\"section-title\">Liên Lạc</div>
                                <div class=\"contact-item\">
                                    <div class=\"contact-icon\">📞</div>
                                    <div>0356340085</div>
                                </div>
                                <div class=\"contact-item\">
                                    <div class=\"contact-icon\">✉️</div>
                                    <div>Nhanngo.290301@gmail.com</div>
                                </div>
                                <div class=\"contact-item\">
                                    <div class=\"contact-icon\">🎂</div>
                                    <div>29/03/2004</div>
                                </div>
                                <div class=\"contact-item\">
                                    <div class=\"contact-icon\">📍</div>
                                    <div>TDP6, phường Phú Bài, Thành phố Huế</div>
                                </div>
                            </div>

                            <!-- Education -->
                            <div class=\"section\">
                                <div class=\"section-title\">Học Vấn</div>
                                <div class=\"education-item\">
                                    <div class=\"education-date\">2016-2018</div>
                                    <div class=\"education-school\">TÊN TRƯỜNG HỌC BORCELLE UNIVERSITY</div>
                                    <ul class=\"education-details\">
                                        <li>• Master of Business Marketing</li>
                                        <li>• Loại tốt nghiệp</li>
                                    </ul>
                                </div>
                                <div class=\"education-item\">
                                    <div class=\"education-date\">2012-2016</div>
                                    <div class=\"education-school\">TÊN TRƯỜNG HỌC BORCELLE UNIVERSITY</div>
                                    <ul class=\"education-details\">
                                        <li>• Master of Business Marketing</li>
                                        <li>• Loại tốt nghiệp</li>
                                    </ul>
                                </div>
                            </div>

                            <!-- Computer Skills -->
                            <div class=\"section\">
                                <div class=\"section-title\">Tin Học</div>
                                <div class=\"skill-item\">
                                    <div class=\"skill-name\">• Microsoft Word</div>
                                    <div class=\"skill-rating\">4★</div>
                                </div>
                                <div class=\"skill-item\">
                                    <div class=\"skill-name\">• Microsoft Excel</div>
                                    <div class=\"skill-rating\">4.5★</div>
                                </div>
                            </div>

                            <!-- Languages -->
                            <div class=\"section\">
                                <div class=\"section-title\">Ngoại Ngữ</div>
                                <div class=\"language-item\">
                                    <div class=\"language-name\">• Tiếng Anh</div>
                                    <div class=\"language-level\">Trung cấp</div>
                                </div>
                                <div class=\"language-item\">
                                    <div class=\"language-name\">• Tiếng Trung</div>
                                    <div class=\"language-level\">Sơ cấp</div>
                                </div>
                            </div>
                        </div>

                        <!-- Right Column -->
                        <div class=\"right-column\">
                            <!-- Name and Title -->
                            <div class=\"name\">NGÔ THỊ THANH NHÀN</div>
                            <div class=\"title\">Sinh viên ngành công nghệ thông tin</div>

                            <!-- Career Objective -->
                            <div class=\"section-divider\"></div>
                            <div class=\"section-title-right\">Mục Tiêu Nghề Nghiệp</div>
                            <div class=\"objective-text\">
                                Tôi là một nhân viên bán hàng chuyên nghiệp với niềm đam mê xây dựng mối quan hệ khách hàng và đạt được các mục tiêu bán hàng. Tôi mong muốn phát triển sự nghiệp trong lĩnh vực bán hàng, áp dụng kỹ năng giao tiếp và thuyết phục mạnh mẽ để tạo ra giá trị cho khách hàng và đóng góp vào sự thành công của tổ chức.
                            </div>

                            <!-- Work Experience -->
                            <div class=\"section-divider\"></div>
                            <div class=\"section-title-right\">Kinh Nghiệm Làm Việc</div>
                            
                            <div class=\"experience-item\">
                                <div class=\"experience-header\">
                                    <div>
                                        <div class=\"experience-company\">Larana Studios</div>
                                        <div class=\"experience-position\">Marketing Manager</div>
                                    </div>
                                    <div class=\"experience-date\">03/2019 - 09/2020</div>
                                </div>
                                <ul class=\"experience-responsibilities\">
                                    <li>• Phụ trách việc tìm kiếm và khai thác thị trường mới, xây dựng danh sách khách hàng tiềm năng: Tại công ty ABC, tôi đã chịu trách nhiệm tìm kiếm và khai thác các thị trường mới, từ đó tạo ra danh sách khách hàng tiềm năng.</li>
                                    <li>• Tôi đã nghiên cứu và đánh giá các xu hướng thị trường để xác định các cơ hội kinh doanh mới. Tôi đã áp dụng các kỹ thuật tiếp thị và xây dựng mạng lưới khách hàng để tăng doanh số bán hàng.</li>
                                </ul>
                            </div>

                            <div class=\"experience-item\">
                                <div class=\"experience-header\">
                                    <div>
                                        <div class=\"experience-company\">Larana Studios</div>
                                        <div class=\"experience-position\">Marketing Manager</div>
                                    </div>
                                    <div class=\"experience-date\">01/2019 - 02/2020</div>
                                </div>
                                <ul class=\"experience-responsibilities\">
                                    <li>• Phụ trách việc tìm kiếm và khai thác thị trường mới, xây dựng danh sách khách hàng tiềm năng: Tại công ty ABC, tôi đã chịu trách nhiệm tìm kiếm và khai thác các thị trường mới, từ đó tạo ra danh sách khách hàng tiềm năng.</li>
                                    <li>• Tôi đã nghiên cứu và đánh giá các xu hướng thị trường để xác định các cơ hội kinh doanh mới. Tôi đã áp dụng các kỹ thuật tiếp thị và xây dựng mạng lưới khách hàng để tăng doanh số bán hàng.</li>
                                </ul>
                            </div>

                            <!-- Other Skills -->
                            <div class=\"section-divider\"></div>
                            <div class=\"section-title-right\">Kỹ Năng Khác</div>
                            <ul class=\"skills-list\">
                                <li>• Branding and Identity Design</li>
                            </ul>
                        </div>
                    </div>
                </body>
                </html>
                """;

        return Objects.requireNonNullElse(html, "");
    }
}


